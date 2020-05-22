@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="IDROLE", nullable=false)
public int getidRole() {      return idRole;     }
public void setidRole(int idRole) {   this.idRole = idRole;  }
private Roles roles;
public Roles getRoles() {
    return roles;
}