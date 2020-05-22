@ManyToOne
@JoinTable(name = "owns", joinColumns = {
@JoinColumn(name = "name", referencedColumnName = "name")}, inverseJoinColumns = {
@JoinColumn(name = "user_name", referencedColumnName = "user_name")})
public User getUser() {
    return user;
}