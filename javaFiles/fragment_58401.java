@Entity @Table class Rating {
  @Id long id;
  @ManyToMany(targetEntity = Progress.class,
              cascade = CascadeType.ALL,
              fetch = FetchType.EAGER)
  @JoinTable(name = "progress_has_rating",
             joinColumns = {@JoinColumn(name = "rating_id", 
                                        referencedColumnName = "id")},
             inverseJoinColumns = {@JoinColumn(name = "progress_id",
                                               referencedColumnName = "id")})
  Set<Progress> progresses;
}

@Entity class Progress {
  @Id long id;
  @Basic long amount;
}