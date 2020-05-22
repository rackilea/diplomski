@ManyToOne(fetch=FetchType.EAGER, targetEntity=UserDetails.class)
@JoinColumn(name="user_id")
UserDetails userDetails;

public UserDetails getUserDetails() {
    return userDetails;
}

public void setUserDetails() {
    this.userDetails = userDetails;
}