private Long id;

private String someTransientField;

@Id
private Long getId() {
    return this.id;
}

@Transient
private String getSomeTransientField() {
    return this.someTransientField;
}