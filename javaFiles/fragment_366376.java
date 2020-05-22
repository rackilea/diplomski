class Parent {
    @NotNull // javax.validation.constraints.NotNull
    private String name;

    @Valid
    List<Child> children;
}