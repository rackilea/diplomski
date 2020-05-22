public class Shower<T> {

  private final Class<T> clazz;

  public Shower(Class<T> clazz) {
    this.clazz = clazz;
  }

  public Result show(T value) throws Exception {
    Class<?> object = Play.application().classLoader().loadClass("views.html." + clazz.getSimpleName() + ".show$");
    Template1<T, Html> template = (Template1<T, Html>)object.getField("MODULE$").get(null);
    return ok(template.render(value));
  }
}