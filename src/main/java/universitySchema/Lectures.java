package universitySchema;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lectures {
    @Id
    private int vorlNr;
    private int sws;
    private String title;

    @ManyToMany
    private List<Students> students= new ArrayList<>();

    @ManyToOne
    private Professors professors;

    public int getVorlNr() {
        return vorlNr;
    }

    public void setVorlNr(int vorlNr) {
        this.vorlNr = vorlNr;
    }

    public int getSws() {
        return sws;
    }

    public void setSws(int sws) {
        this.sws = sws;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public Professors getProfessor() {
        return professors;
    }

    public void setProfessors(Professors professors) {
        this.professors = professors;
    }
}
