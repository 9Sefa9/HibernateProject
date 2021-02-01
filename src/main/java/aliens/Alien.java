package aliens;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

@Entity(name="alien_entity")
@Table(name="alien_table")
public class Alien {
    @Id
    private int id;
    @Column(name="name")
    private AlienName name;
    @Column(name="color")
    private String color;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }
}
