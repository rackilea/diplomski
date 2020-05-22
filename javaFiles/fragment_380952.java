public class DynamicFieldAccessArrayWrapper {
    private ArrayList _wrappedArray;

    public Object getNestedFields(int[] selectedIndexes, String[] fieldPath) {
        // Pseudo-code:
        ArrayList result = new ArrayList();
        if (selectedIndexes == null) {
            selectedIndexes = 1:_wrappedArray.length();
        }
        for (ix in selectedIndexes) {
            Object obj = _wrappedArray.get(ix-1);
            Object val = obj;
            for (fieldName in fieldPath) {
                java.lang.reflect.Field field = val.getClass().getField(fieldName);
                val = field.getValue(val);
            }
            result.add(val);
        }
        return result.toArray(); // Return as array so Matlab can auto-unbox it; will need more type detection to get array type right
    }
}