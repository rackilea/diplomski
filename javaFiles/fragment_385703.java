public class Student implements Serializable{
    @EmbeddedId
    private StudentPK name;

    @ManyToOne
    @JoinColumn(name="course_id")
    private Course course;
    .....

    @Embeddable
    public static class StudentPK implements Serializable {
        @Column(name="first_name")
        private String firtName;

        @Column(name="last_name")
        private String lastName;

        ....
    }
}