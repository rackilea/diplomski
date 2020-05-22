package forum11001458;

import javax.xml.bind.annotation.XmlElement;

public class Result {

    @XmlElement(name="Course")
    private String course;

    @XmlElement(name="Score")
    private String score;

}