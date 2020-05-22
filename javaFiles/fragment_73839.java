public class Student extends Peopple {

    private Course course;

    public Course getCourse() {return course;}
    public void setCourse(Course course) {this.course = course;}

    @Override
    public String toString() {
        return return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}