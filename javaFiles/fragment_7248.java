@EmbeddedId // using compound primarykey
public CourseInterestPK key;

@MapsId("courseCode") // map embedded key
@ManyToOne
@JoinColumn(name = "course_code", referencedColumnName = "code")
public Course course;

@MapsId("interestType") // map embedded key
@Constraints.Required
public InterestType interest_type;