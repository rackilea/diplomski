@Getter
@Setter
@EqualsAndHashCode (callSuper = true)
@ToString(callSuper = true)
public class TypeA_A
  extends TypeA {

    @SerializedName ("a")
    protected AA aValue;

    @ToString
    private static class AA {
        @SerializedName ("aa")
        private String aaValue;
    }
}