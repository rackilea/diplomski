class Pchi{
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name="new_id", referencedColumnName="menu_id")
private Rlhi rlhi;
}

class Rlhi{
@OneToMany(mappedBy="rlhi")
private <Set> Pchi pchis;
}