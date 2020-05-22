@ManyToOne
@JoinColumn(name="USERID")
public Employee getMember(){
    return emp;
}
public void setMember(Employee e){
    emp = e;
}
@ManyToOne
@JoinColumn(name="COHORT_GROUPID")
public CohortGroup getGroup(){
    return group;
}
public void setGroup(CohortGroup cg){
    group   = cg;
}