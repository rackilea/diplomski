@IndexedEmbedded
@Field(name="roles", analyze=Analyze.NO, index=Index.YES)
@Enumerated(EnumType.STRING)
@ElementCollection(targetClass = UserRole.class, fetch = FetchType.EAGER)
@JoinTable(name = "user_roles", joinColumns = {@JoinColumn(name = "user_id")})
List<UserRole> roles = new ArrayList<>();