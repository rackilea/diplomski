public class MyClass{

    private String myName;

    public MyClass(String name){
        this.myName = name;
    }
    @Override
    public String toString(){
        return myName;
    }

}

myComboBox.add(new MyClass("Harry"));
myComboBox.add(new MyClass("John"));
myComboBox.add(new MyClass("Mary"));
myComboBox.add(new MyClass("Harry"));