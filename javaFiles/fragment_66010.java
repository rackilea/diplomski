@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class UserAccount implements UserDetails {

    @Id
    private String id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String idnp;

    @Email
    private String email;

    @Builder.Default()
    private boolean active = true;

    @Builder.Default()
    @DBRef
    private List<Role> roles = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return active;
    }

    @Override
    public boolean isAccountNonLocked() {
        return active;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return active;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }
}