@NamedNativeQuery( name = "customJoin", 
                   query = "SELECT MIN(t1.Id + 1) AS nextID FROM MyTable t1 LEFT JOIN MyTable t2 ON t1.Id + 1 = t2.Id WHERE t2.Id IS NULL",
                   resultSetMapping = "customJoinMapping" )

@SqlResultSetMapping( name = "customJoinMapping",
                      entities = @EntityResult( entityClass = MyTable.class, fields = @FieldResult( name = "id", column = "nextID" ) ) )
@Entity
@Access( AccessType.Field )
public class MyTable {
   private int id;

   public int getId() {
      return this.id;
   }

   public void setId( int id ) {
      this.id = id;
   }
}