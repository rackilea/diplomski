@Retention(RetentionPolicy.RUNTIME) @Target({ElementType.TYPE})
public @interface Column {
    ColumnType value();
    String property() default "";
    boolean editable() default false;
}

@UI.App(
    name = "locations",
    columns = {
            @UI.Presenter.Column(value=ColumnType.PROPERTY, property="title"),
            @UI.Presenter.Column(value=ColumnType.PROPERTY, property="enabled"),
            @UI.Presenter.Column(ColumnType.STATUS),
            @UI.Presenter.Column(ColumnType.LAST_MODIFIED)
    }
)