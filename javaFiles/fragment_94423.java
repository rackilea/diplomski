@Column
    @NotNull(message = "error.title.notnull")
    @Size(min = 1, max = 30, message = "error.title.size")
    private String title;
    @Column
    @Size(max = 100, message = "error.description.size")
    private String description;