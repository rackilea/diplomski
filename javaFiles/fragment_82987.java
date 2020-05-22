@Document(collection="JSON")
public class JSON {

    @Id
    public String id;

    @Field("squares")
    public Square square;

    @Field("dots")
    public Dot dot;

    public JSON(){};
    public JSON(String id, Square square,Dot dot){
        this.id = id;
        this.square = square;
        this.dot = dot;
    };


}