public class MethodChooser {
    public static void main(String[] args) {
        ChooseMethodA m = new ChooseMethodB();
        m.doSomething(10);
    }
}