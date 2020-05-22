private List<Todo> objects = new List<>(); //NEW
private Context mcontext;
int mresource;

public Todoadapter(@NonNull Context context, int resource, @NonNull List<Todo> objects) {
    super(context, resource, objects);
    this.mresource=resource;
    this.mcontext= context;
    this.objects = objects //NEW

}