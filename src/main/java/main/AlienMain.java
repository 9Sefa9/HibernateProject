package main;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import aliens.Alien;
import aliens.AlienName;
import aliens.Laptop;

/*
* Q: How to Fetch Data ?
* A: ToBeFetchedClass t = (ToBeFetchedClass) session.get(ToBeFetchedClass.class, 5);
*    where 5 is the primary key of that entitys attribute.
* */

public class AlienMain {
    public static void main(String[] args){
        Alien a = new Alien();
        AlienName aa = new AlienName();
        Laptop l = new Laptop();
        l.setBrand("Toshiba");
        l.setPrice(1000);
        l.setLid(101);

        aa.setFname("John");
        aa.setLname("Smith");
        aa.setMname("Junior");

        a.getLaps().add(l);
        a.setName(aa);
        a.setColor("Red");
        a.setId(1);
        //configures hibernate.cfg.xml
        Configuration config = new Configuration().configure();
        config.addAnnotatedClass(Laptop.class);
        config.addAnnotatedClass(Alien.class);
        SessionFactory factory = config.buildSessionFactory();

        //Second-level Caching - Using HQL Query
        //####Session 1
        Session session1 = factory.openSession();
        session1.beginTransaction();

        Query q1 = session1.createQuery("select a.id from Alien a where a.id= :firstAlienId");
        q1.setParameter("firstAlienId",1);
        Integer aid = (Integer)q1.uniqueResult();
        System.out.println("HQL - AlienID: "+aid);

        session1.getTransaction().commit();
        session1.close();

        System.out.println("SESSION 1 END");
        //####Session 2 - Using SQL - Query
        Session session2 = factory.openSession();
        session2.beginTransaction();

        NativeQuery q2 = session2.createNativeQuery("select * from Alien where id=1");
        q2.setCacheable(true);
        q2.addEntity(Alien.class);

        List<Alien> a2 = q2.list();
        System.out.println("SQL - AlienClass:");
        for(Alien alien: a2)
            System.out.println("An alien:"+alien);

        session2.getTransaction().commit();
        session2.close();

        System.out.println("SESSION 2 END");


        /*

        lazy approach. It will Fetch, only if you need it+
        in Lazy fetch type, Hibernate wonâ€™t load the relationships for any particular object instance.

        Two queries are done:  1) Alien and 2) Laptops.
        Set a Fetch=FetchType.Eager inside an Entity class to change the query type.

        Eager will by default load ALL of the relationships related to a particular object loaded by Hibernate.
        ALL IN ALL:

        FetchType.LAZY = Doesnâ€™t load the relationships unless explicitly â€œasked forâ€� via getter
        FetchType.EAGER = Loads ALL relationships

        1) Query
        Alien a1 = session.get(Alien.class,1);


        2) Query
        Collection<Laptop> laps = a1.getLaps();

        for(Laptop li : laps){
            System.out.println(li);
        }

        // session.save(a);
        transaction.commit();
         */


    }
}
