@ManyToMany
@JoinTable(
  name="users_friends",
  joinColumns=@JoinColumn(name="user_id", referencedColumnName="id"),
  inverseJoinColumns=@JoinColumn(name="user_friend_id", referencedColumnName="id"))
private List<UserEntity> friends;