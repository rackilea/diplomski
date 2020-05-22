class A {
    @OneToMany
    @JoinColumn(name = "a_id")
    private Set<C> cSet;
}

class B {
   @OneToMany
   @JoinColumn(name = "b_id")
   private Set<C> cSet;
}