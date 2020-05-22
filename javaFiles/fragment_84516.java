public class Shower<T> {

  public final Template1<T, Html> template;

  public Shower(Template1<T, Html> template) {
    this.template = template;
  }

  public Result show(T value) {
    return ok(template.render(value));
  }

}