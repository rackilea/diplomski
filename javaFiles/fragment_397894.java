import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        var newEmptyElementData = new Object[]{"Hello", "World!"};
        updateEmptyElementDataField(newEmptyElementData);

        var list = new ArrayList<>(0);

        // toString() relies on iterator() which relies on size
        var sizeField = list.getClass().getDeclaredField("size");
        sizeField.setAccessible(true);
        sizeField.set(list, newEmptyElementData.length);

        System.out.println(list);
    }

    private static void updateEmptyElementDataField(Object[] array) throws Exception {
        var field = ArrayList.class.getDeclaredField("EMPTY_ELEMENTDATA");
        FieldHelper.makeNonFinal(field);
        field.setAccessible(true);
        field.set(null, array);
    }

}