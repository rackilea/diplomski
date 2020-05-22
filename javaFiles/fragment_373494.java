@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        resolver = MyObjectIdResolver.class, 
        property = "id", scope = B.class)
public class B  {
   // ...
}