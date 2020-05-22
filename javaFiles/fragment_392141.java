@Entity
public class A { 
  @Id
  private Long id;

  //getters
  //setters
}

@Entity
public class B {
  @Id
  private Long id;

  @MapsId
  @OneToOne(optional=false, fetch=FetchType.EAGER)
  @JoinColumn(nullable=false, name="id")
  private A a;

  //getters
  //setters
}