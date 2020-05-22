GET  /foo  controller.Foo.index(id: Option[java.lang.Long])

public static Result index(final Option<Long> id) {
    if (!id.isDefined()) {...}
    ...
}