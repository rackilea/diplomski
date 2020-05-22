@Column(name = "password", nullable = false)
private String password;

@JsonIgnore
public String getPassword() {
    return password;
}

public void setPassword(String password) {
    this.password = password;
}