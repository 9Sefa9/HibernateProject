package aliens;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.Embeddable;
/*Q: What is @Embeddable ?
* A: With @Embeddable we say, that we want to embedd "this" class into "that" class.
*    So when we create an Object of an Embeddable Class which has 3 attributes and put in the entity the instance of it,
*    its attributes will be added by 3.   example: a b c => b => x,y,z result a,x,y,z,c
*
* */
@Embeddable
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class AlienName {

    private String fname;
    private String lname;
    private String mname;

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    @Override
    public String toString() {
        return "AlienName{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", mname='" + mname + '\'' +
                '}';
    }
}
