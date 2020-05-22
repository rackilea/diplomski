public class ArrayCastTest {
    public static void main(String[] argv) {
        Object[] objArray;
        StringBuilder[] sbArray;
        objArray = getArray();
        sbArray = (StringBuilder[]) objArray;
        System.out.println(sbArray.toString());
    }

    public static Object[] getArray() {
        return new StringBuilder[5];
    }
}