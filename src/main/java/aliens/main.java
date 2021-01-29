package aliens;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class main {
    public static void main(String[] args){
        Alien a = new Alien();
        a.setColor("test");
        System.out.println(a.getColor());

        //configures hibernate.cfg.xml
        Configuration config = new Configuration().configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        session.save(a);
    }
}
