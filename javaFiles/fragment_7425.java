@Entity(name="A")
class A {
   @Id
   int id;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "bPk.a")
   @Cascade(value = { CascadeType.DELETE })
   Set<B> listB;
}