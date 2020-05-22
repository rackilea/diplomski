@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NoArgsConstructor @RequiredArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @NonNull @NotNull
    private String id;

    // ... Other non pk fields

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Collection<UserPermission> permissions;
}