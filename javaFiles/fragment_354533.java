public class PrimitiveMadness {
    static byte bytePrimitiveField;
    static Byte byteWrapperField;

    public static void main(String[] args) throws Exception {
        System.out.println("Field type  =     " + PrimitiveMadness.class.getDeclaredField("bytePrimitiveField").getType());
        System.out.println("Is a byte   =     " + (PrimitiveMadness.class.getDeclaredField("bytePrimitiveField").getType() == byte.class));
        System.out.println("Is a primitive? = " + PrimitiveMadness.class.getDeclaredField("bytePrimitiveField").getType().isPrimitive());
        System.out.println("Wrapper field   = " + PrimitiveMadness.class.getDeclaredField("byteWrapperField").getType());
    }

}