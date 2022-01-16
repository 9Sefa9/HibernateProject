package universitySchema;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professors {
    @Id
    private int persNr;
    private String rank;
    private int room;
    private String name;

    @OneToMany
    private List<Assistants> assistants = new ArrayList<>();

    @OneToMany
    private List<Lectures> lectures= new ArrayList<>();

    @OneToMany
    private List<Students> students= new ArrayList<>();

    public int getPersNr() {
        return persNr;
    }

    public void setPersNr(int persNr) {
        this.persNr = persNr;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Assistants> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<Assistants> assistants) {
        this.assistants = assistants;
    }

    public List<Lectures> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lectures> lectures) {
        this.lectures = lectures;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }
}
