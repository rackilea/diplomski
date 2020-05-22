@Getter
@Setter
public class User {

    private userName;

    @Getter(onMethod = @__( @JsonIgnore ))
    @Setter
    private password;
}