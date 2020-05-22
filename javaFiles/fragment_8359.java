// add this constructor
public SimpleGrantedAuthority() { 
}

public SimpleGrantedAuthority(String role) {
  Assert.hasText(role, "A granted authority textual representation is required");
  this.role = role;
}