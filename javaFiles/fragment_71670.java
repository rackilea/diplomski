public class MyClass {
    private WebElement element;

    private MyClass(WebElement element) {
        this.element = element;
    }

    public static MyClass newMethod(String str) {
        //do something and THEN pass WebElement you want to click.
        return new MyClass(element);
    }

    public void click() {
        element.click();
    }
}

//usage
public static void main(String[] args) {
    MyClass.newMethod("myString").click();
}