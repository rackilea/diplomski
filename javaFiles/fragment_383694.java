public class Test {
    public int field1 = 1;
    public int field2 = 2;
    public int field3 = 3;
    // this method changes values assigned to field1, field2 and field3:
    public void setFields()
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        for (int i = 1; i < 4; i++) {
            Test.class.getField("field" + i).set(this, 25); // Here is what you may be looking for, you dynamically find field1, field2, ...
        }
    }

    public static void main(String[] args)
            throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
        Test t = new Test();
        for (int i = 1; i < 4; i++) {
            int j = (Test.class.getField("field" + i).getInt(t)); // Another example
            System.out.print(j + " ");
        }
        t.setFields();
        for (int i = 1; i < 4; i++) {
            int j = (Test.class.getField("field" + i).getInt(t));
            System.out.print(j + " ");
        }
    }

}