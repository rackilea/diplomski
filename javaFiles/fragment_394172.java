@MapsId("user")
@NonNull @NotNull
@ManyToOne
@JoinColumn(name = "user", updatable = false, insertable = false)
private User user;

@MapsId("permission")
@NonNull @NotNull
@ManyToOne
@JoinColumn(name = "permission", updatable = false, insertable = false)
private Permission permission;