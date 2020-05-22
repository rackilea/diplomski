public interface Thing {
  void run();
}
Context context = Context.create("js");
Value jsobj = context.eval("js", "({run: () => console.log('hi')})");
Thing javaobj = jsobj.as(Thing.class);
javaobj.run();