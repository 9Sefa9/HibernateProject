package universitySchema;

import aliens.Alien;
import aliens.AlienName;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class universityMain {

        public static void main(String[] args){
            Students students = new Students();
            Professors professors = new Professors();
            Assistants assistants = new Assistants();
            Lectures lectures = new Lectures();

            students.setMatrNr(24002);
            students.setName("Xenokrates");
            students.setSemester(18);

            professors.setPersNr(2126);
            professors.setName("Sokrates");
            professors.setRank("C4");
            professors.setRoom(226);

            assistants.setPersNr(3002);
            assistants.setName("Platon");
            assistants.setExpertiseArea("Ideenlehre");

            lectures.setVorlNr(5001);
            lectures.setTitle("Grundzüge");
            lectures.setSws(4);

            //configures hibernate.cfg.xml
            Configuration config = new Configuration().configure();
            config.addAnnotatedClass(Students.class);
            config.addAnnotatedClass(Professors.class);
            config.addAnnotatedClass(Assistants.class);
            config.addAnnotatedClass(Lectures.class);
            ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();

            SessionFactory factory = config.buildSessionFactory(sr);
            Session session = factory.openSession();

            Transaction transaction = session.beginTransaction();

            session.save(students);
            session.save(professors);
            session.save(assistants);
            session.save(lectures);
            // a = (Alien)session.get(Alien.class,5);

            transaction.commit();


            session.close();
            sr.close();
        }


}
