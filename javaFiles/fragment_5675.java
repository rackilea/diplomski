@Id
private Long id;

@Transient
private String someTransientField;

private Long getId() {
    return this.id;
}

private String getSomeTransientField() {
    return this.someTransientField;
}