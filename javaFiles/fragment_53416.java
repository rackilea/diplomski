public class A {
  @ManyToMany
  @JoinTable(name = "A_relX_B",
    joinColumns = {@JoinColumn(name = "A_ID")},
    inverseJoinColumns = {@JoinColumn(name = "B_ID")}
  )
  Set<B> relationX;

  @ManyToMany
  @JoinTable(name = "A_relY_B",
    joinColumns = {@JoinColumn(name = "A_ID")},
    inverseJoinColumns = {@JoinColumn(name = "B_ID")}
  )
  Set<B> relationY;

  @ManyToMany
  @JoinTable(name = "A_relZ_B",
    joinColumns = {@JoinColumn(name = "A_ID")},
    inverseJoinColumns = {@JoinColumn(name = "B_ID")}
  )
  Set<B> relationZ;
}