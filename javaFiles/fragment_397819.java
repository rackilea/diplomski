@ManyToOne
@JoinColumn(name = "SCHOOL_ID", table = "SCHOOL")
private School school;


public School getSchool() {
    return school;
}

public void setSchool(School school) {
    this.school=school;
}