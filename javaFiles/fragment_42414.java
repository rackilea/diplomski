import org.graalvm.polyglot.Context;

public class Test {

  public static class Data {
    public String name = "HelloWorld";
    public String getName() {
        return this.name;
    }
  }

  public static void main(String[] args) {
    Context context = Context.newBuilder("js").allowHostAccess(true).build();
    context.getBindings("js").putMember("d", new Data());

    context.eval("js", "var x = d.name;");

    System.out.println(
        context.getBindings("js").getMember("x").asString()
    );
  }
}