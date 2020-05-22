public class A
{
  @OneToMany(cascade = CascadeType.ALL)
  Collection b;
}

public class B
{
  @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}) //I don't want to cascade a persist operation as that might make another A object)
  A a;
}