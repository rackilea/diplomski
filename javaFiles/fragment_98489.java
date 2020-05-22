@Getter
@Setter
@EqualsAndHashCode (callSuper = true)
@ToString (callSuper = true)
public class TypeB extends SuperType  {

// no member declared here

    protected static abstract class B {
        @SerializedName ("b1")
        protected String b1Value;
        @SerializedName ("b2")
        protected String b2Value;
    }
}