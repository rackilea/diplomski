@Getter
@Setter
@EqualsAndHashCode (callSuper = true)
@ToString (callSuper = true)
public class TypeB_A
  extends TypeB {

    @SerializedName ("b")
    protected BA bValue;

    @ToString
    private static class BA extends B {
        @SerializedName ("ba")
        private String baValue;
    }
}