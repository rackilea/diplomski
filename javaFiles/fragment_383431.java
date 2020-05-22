@Embeddable
public class Course implements Serializable {

@Column(name = "TERM_CODE")
private Long termCode;

@Column(name = "SUBJECT_CODE")
private String subjectCode;

@Transient
Collection<CourseSchedule> schedule = new ArrayList<CourseSchedule>();

public void setSchedule(Collection<CourseSchedule> schedule) {
    this.schedule = schedule;
}
public Collection<CourseSchedule> getSchedule() {
    return schedule;
}

public Long getTermCode() {
 return termCode;
 }

 public void setTermCode(Long termCode) {
 this.termCode = termCode;
 }

 public String getSubjectCode() {
return subjectCode;
 }

 public void setSubjectCode(String subjectCode) {
 this.subjectCode = subjectCode;
 }
}