public class MyClass<T extends IBankData> {

    public void copyData(T instance) {
        T.getFieldXXX() // this would work because T extends IBankData

        if (T instanceof Bank) {
            ((Bank) T).getBankSpecificField();
        }
    }
}