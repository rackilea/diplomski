public abstract class TemplateMethodLoop<T> {
    public abstract void execute(T t);

    public void loop(List<T> array) {
        for (T t : array) {
            this.execute(t);
        }
    }
}

public class TemplateMethodPatternClient {
    public void stringListPrinter(List<String> stringList) {
        new TemplateMethodLoop<String>() {
            public void execute(String string) {
                System.out.println(string);
            }
        }.loop(stringList);
    }
}