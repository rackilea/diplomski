class StudentSubject {
    @Id
    @ManyToOne
    @JoinColumns({
            @JoinColumn(referencedColumnName = "name"),
            @JoinColumn(referencedColumnName = "teacher_email") })
    private Subject subject;
}