class CompositebPK {
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumns({ @JoinColumn(referencedColumnName = "id", nullable = false) })
   A a;
   @Column(name="user_name")
   String uname;
}