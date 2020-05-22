public class ClassB {
    private ClassD[] array = new ClassD[10];
    private int index;

    public void addElement(ClassB element) {
        array[index++] = element;
    }
}