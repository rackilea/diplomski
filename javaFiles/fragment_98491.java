@Getter
@Setter
@EqualsAndHashCode (callSuper = true)
@ToString (callSuper = true)
public class TypeB_B
  extends TypeB {

    @SerializedName ("b")
    protected BB bValue;

    @ToString
    private static class BB extends B {
        @SerializedName ("bb")
        private String bbValue;

        @SerializedName ("bb1")
        private String bb1Value;
    }
}