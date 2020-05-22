public Assignment {

  // Your model.
  ...

  @ManyToMany
  @JoinTable(name = "Assignements_has_group ", joinColumns = { 
        @JoinColumn(name = "ASSIGNMENT_ID", nullable = false, updatable = false) }, 
        inverseJoinColumns = { @JoinColumn(name = "GROUP_ID", 
                nullable = false, updatable = false) })
  public Set<Group> groupes;

}