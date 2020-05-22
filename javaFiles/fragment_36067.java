@Indexes({@Index(fields= {@Field("a"), @Field("b")}), @Index(options= @IndexOptions(unique = true), fields= {@Field("c")})})
@Entity(collection_name)
public class IndexClass {

        @Id
        private Long id;
        private String a;
        private String b;
        private String c;

     // Getters and Setters

}