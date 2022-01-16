package universitySchema;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Students {
    @Id
    private int matrNr;

    private String name;

    private int semester;

    @ManyToOne
    private Professors professors;

    @ManyToMany
    private List<Lectures> lectures= new ArrayList<>();

    public int getMatrNr() {
        return matrNr;
    }

    public void setMatrNr(int matrNr) {
        this.matrNr = matrNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Professors getProfessors() {
        return professors;
    }

    public void setProfessors(Professors professors) {
        this.professors = professors;
    }

    public List<Lectures> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lectures> lectures) {
        this.lectures = lectures;
    }
}
