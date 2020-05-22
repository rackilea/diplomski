@ManyToMany(targetEntity=User.class)
@JoinTable(
    name="user_users",
    joinColumns=@JoinColumn(name="user_1_id", nullable=false),
    inverseJoinColumns=@JoinColumn(name="user_2_id", nullable=false)
)
public Set<ElementBean> getConnections() {
    return connections;
}