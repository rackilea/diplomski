@Entity
@Table(name="AppUser")
public class AppUser extends BaseEntity {
    @OneToMany(mappedBy="id.appUser", fetch=FetchType.EAGER)
    @MapKeyJoinColumn(name="id")
    private Set<AppUserSecurityQuestion> securityAnswers;
    ...
}