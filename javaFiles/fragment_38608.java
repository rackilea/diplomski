@OneToMany(cascade = CascadeType.ALL)
@JoinTable(name = "estates_owners",
    inverseJoinColumns=@JoinColumn(name="share_id"))
@MapKeyJoinColumn(name="owner_id")
public Map<Owner, Share> getOwnerSharesMap() {
    return ownerSharesMap;
}