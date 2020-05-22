public class MenusAction extends Action<Menus> {
  public Result call(Http.Context ctx) {
    if("MyController".equals(configuration.value)) {
      // do something
    }

    ctx.args.put("menus", Menu.find.all());
    return delegate.call(ctx);
  }
}