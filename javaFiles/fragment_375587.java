public class EntityA {
   @OneToMany(mappedBy = "a") 
   private List<EntityB> bList;
 }

 public class EntityB {
   @ManyToOne
   private EntityA a;
   @OneToMany(mappedBy = "b")
   private List<EntityC> cList; 
 }

 public class EntityC {
   @ManyToOne
   private EntityB b;
 }