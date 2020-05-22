public class View {
    interface Full {}
    interface Summary {}
}

public class B implements Serializable{
    @JsonView({View.Summary,View.Full})
    String name;

    @JsonView(View.Full)
    Set<D> ds;

}