@XmlRootElement(name="catalog")
@XmlAccessorType(XmlAccessType.FIELD)
class catalog {
    @XmlElement(name="course")
    curso course;

    public curso getCourse() {
        return course;
    }

    public void setCourse(curso course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "catalog [course=" + course + "]";
    }
}