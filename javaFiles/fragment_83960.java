import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Student")
@XmlType(propOrder = { "firstName", "lastName", "id", "scoreRecords" })
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private List<ScoreRecord> scoreRecords;

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlElement(name = "Id")
    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlElement(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlElement(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setScoreRecords(List<ScoreRecord> scoreRecords) {
        this.scoreRecords = scoreRecords;
    }

    @XmlElementWrapper(name = "MarksList")
    @XmlElement(name = "Mark")
    public List<ScoreRecord> getScoreRecords() {
        return scoreRecords;
    }
}