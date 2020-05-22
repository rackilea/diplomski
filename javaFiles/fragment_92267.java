public class MyClass { // you can name your class like you want
    public static void main(String args[]) {
        final MyClass instance = new MyClass(); //assuming there is a non-argument constructor
        instance.loadData(); // call "loadData" on a specifc instance of MyClass
    }

    public void loadData() { /* method code */ }
}