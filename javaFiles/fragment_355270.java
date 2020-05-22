@Controller
public class DemoController {

    public void soSomething(String s, @MyParamAnnotation Double d, Integer i) {
    }

    public void doSomething(String s, long l, @MyParamAnnotation int i) {
    }

    public void doSomething(@MyParamAnnotation String s) {
    }

    public void doSomething(long l) {
    }
}