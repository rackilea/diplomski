GET  /foo  controller.Foo.index(id: Option[Long])

public static Result index(final Option<scala.Long> id) {
    if (!id.isDefined()) {...}
    ...
}