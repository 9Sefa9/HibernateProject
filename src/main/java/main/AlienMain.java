package main;


import aliens.Alien;
import aliens.AlienName;
import aliens.Laptop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import java.util.ArrayList;
import java.util.Collection;

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
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

     //   session.save(a);

        Alien a1 = session.get(Alien.class,1);

        System.out.println(a1);

        transaction.commit();
        /*

        lazy approach. It will Fetch, only if you need it+
        in Lazy fetch type, Hibernate won’t load the relationships for any particular object instance.

        Two queries are done:  1) Alien and 2) Laptops.
        Set a Fetch=FetchType.Eager inside an Entity class to change the query type.

        Eager will by default load ALL of the relationships related to a particular object loaded by Hibernate.
        ALL IN ALL:

        FetchType.LAZY = Doesn’t load the relationships unless explicitly “asked for” via getter
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
