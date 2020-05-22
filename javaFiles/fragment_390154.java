@OneToMany(mappedBy="member")
public List<CohortGroupMember> getMemberGroups(){
   return memberGroups;
}
public void setMemberGroups(List<CohortGroupMember> grps){
   memberGroups = grps;
}