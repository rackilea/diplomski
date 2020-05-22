@Entity
class A {
    @OneToMany(mappedBy = "parentB", cascade = CascadeType.REMOVE)
    private Set<Child> childrenB;

    @OneToMany(mappedBy = "parentC", cascade = CascadeType.REMOVE)
    private Set<Child> childrenC;
}

@Stateless
class daoA {
  @PersistenceContext
  EntityManager em;

  public void remove(A a){
    em.delete(a);
  }
}