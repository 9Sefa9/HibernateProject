package aliens;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistryBuilder;


public class main {
    public static void main(String[] args){
        Alien a = new Alien();
        a.setId(2);
        a.setColor("BLUE");
        a.setName("Kuila");
        System.out.println(a.getColor());

        //configures hibernate.cfg.xml
        Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);

        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

        SessionFactory factory = config.buildSessionFactory(sr);
        Session session = factory.openSession();
       // session.beginTransaction();
        Transaction transaction = session.beginTransaction();

        session.save(a);

        transaction.commit();
        session.close();
        sr.close();
    }
}
