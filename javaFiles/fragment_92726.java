private int id;
@Size(max = CommonConstants.NAME, message = "length exceeds : name")
private String name;
@Size(max = CommonConstants.ROLE, message = "length exceeds : role")
private String role;

public int getId() {
    return id;
}

public void setId(int id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}