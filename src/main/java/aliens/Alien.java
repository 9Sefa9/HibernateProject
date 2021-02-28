package aliens;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
/*Q:    What is : @Entity(name="alien_nameEntity")
*                 @Table(name="alien_nameTable")
* A:    The name in @Entity is for JPA-QL queries, it defaults to
*       the class name without package (or unqualified class name, in
*       Java lingo), if you change it you have to make sure you
*       use this name when building queries.
*
* The name in @Table is the table name where this entity is saved.
*------------
* Q: How to ignore attribute to be not considered in the database?
* A: @Transient
*    private String name
* */

@Entity
public class Alien {
    @Id
    private int id;
    private AlienName name;
    private String color;

    @OneToMany(mappedBy="alien")
    private Collection<Laptop> laps = new ArrayList<Laptop>();

    public Alien(){

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Collection<Laptop> getLaps() {
        return laps;
    }

    public void setLaps(Collection<Laptop> laps) {
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", color='" + getColor() + '\'' +
                ", laps=" + getLaps() +
                '}';
    }

}
