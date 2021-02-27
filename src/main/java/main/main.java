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

public class main {
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

        Alien a1 = session.get(Alien.class,1);
        Collection<Laptop> laps = a1.getLaps();

        for(Laptop li : laps){
            System.out.println(li);
        }
       // session.save(a);
        transaction.commit();

    }
}
