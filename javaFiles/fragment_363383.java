@Entity
@Table(schema = "admins", name = "admin", uniqueConstraints = @UniqueConstraint(columnNames={"adminId"}))
@TypeDefs({
    @TypeDef(name = "EnumerationType", typeClass = EnumerationType.class)
})
public class Admin {

private UUID adminId;
private String name;
private String firstName;
private String lastName;
private AdminRole adminRole;
private Date created;
private Date lastModified;
private UUID createdBy;
private UUID lastModifiedBy;
private boolean delete;


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
public UUID getAdminId() {
    return adminId;
}

public void setAdminId(UUID adminId) {
    this.adminId = adminId;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

@Basic
@Enumerated(EnumType.STRING)
@Type(type = "EnumerationType")
public AdminRole getAdminRole() {
    return adminRole;
}

public void setAdminRole(AdminRole adminRole) {
    this.adminRole = adminRole;
}

@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
@Temporal(TemporalType.TIMESTAMP)
public Date getCreated() {
    return created;
}

public void setCreated(Date created) {
    this.created = created;
}

@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
@Temporal(TemporalType.TIMESTAMP)
public Date getLastModified() {
    return lastModified;
}

public void setLastModified(Date lastModified) {
    this.lastModified = lastModified;
}

public UUID getCreatedBy() {
    return createdBy;
}

public void setCreatedBy(UUID createdBy) {
    this.createdBy = createdBy;
}

public UUID getLastModifiedBy() {
    return lastModifiedBy;
}

public void setLastModifiedBy(UUID lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
}

public boolean isDelete() {
    return delete;
}

public void setDelete(boolean delete) {
    this.delete = delete;
}
}