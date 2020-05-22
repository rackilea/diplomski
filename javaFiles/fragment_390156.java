@OneToMany(mappedBy="group")
public List<CohortGroupMember> getMembers(){
    return members;
}
public void setMembers(List<CohortGroupMember> emps){
    members = emps;
}