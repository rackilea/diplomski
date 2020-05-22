@Entity(name="Course")
public class CourseSchedule {
private String room;
private String day;

@Id
@GeneratedValue
private int id;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

@Embedded
private Course course;

public Course getCourse() {
    return course;
}

public void setCourse(Course course) {
    course.schedule.add(this);
    this.course = course;
}

public String getRoom() {
    return room;
}

public void setRoom(String room) {
    this.room = room;
}

public String getDay() {
    return day;
}

public void setDay(String day) {
    this.day = day;
}
}