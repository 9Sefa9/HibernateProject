package main;

import aliens.Alien;
import aliens.AlienName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;

/*
* Q: How to Fetch Data ?
* A: ToBeFetchedClass t = (ToBeFetchedClass) session.get(ToBeFetchedClass.class, 5);
*    where 5 is the primary key of that entitys attribute.
* */

public class main {
    public static void main(String[] args){
        Alien a = new Alien();
        AlienName alienName = new AlienName();
        alienName.setFname("John");
        alienName.setLname("Carter");
        alienName.setMname("Ford");

        a.setId(10);
        a.setColor("GREEN");
        a.setName(alienName);

        //configures hibernate.cfg.xml
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        SessionFactory factory = config.buildSessionFactory(sr);
        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        session.save(a);
       // a = (Alien)session.get(Alien.class,5);

        transaction.commit();


        session.close();
        sr.close();
    }
}
