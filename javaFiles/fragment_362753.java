@ManyToMany
@JoinTable(name = "User_Mail_To")
public List<User> sentTO;

@ManyToMany
@JoinTable(name = "User_Mail_Bcc")
public List<User> sentBCC;