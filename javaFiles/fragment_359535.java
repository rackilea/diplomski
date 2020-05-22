@Entity
public class Staff {
    @Id
    @Field(name="id_numeric")
    @NumericField(forField="id_numeric")
    protected Long id;
    // other fields
}