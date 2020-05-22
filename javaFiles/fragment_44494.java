public class OuterClass implements Serializable{

    private OuterEnum.NestedEnum nested;
    private OuterEnum outer;

    public enum OuterEnum {
        A(NestedEnum.X), B(NestedEnum.Y), C(NestedEnum.X);

        NestedEnum nestedValue;

        private OuterEnum(NestedEnum nv) {
            nestedValue = nv;
        }


        private enum NestedEnum {
            X, Y;
        }
    }
}