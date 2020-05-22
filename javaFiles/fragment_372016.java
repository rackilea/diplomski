@OneToMany
@JoinTable(
  name="Contract_Party", 
  joinColumns = {@JoinColumn(name="party_id",referencedColumnName="party_id")},
  inverseJoinColumns = {@JoinColumn(name="contract_id", referencedColumnName="contract_id")}
}
@WhereJoinTable  ( "ROLE = 'SIGNER' ")
private List<Contract> contracts;