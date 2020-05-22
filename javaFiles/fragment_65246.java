Context mContext;

public home_listadapter(Context context, int resource, ArrayList<home_listview_model> objects) {
super(context, resource, objects);
vi = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
Resource = resource;
restaurant_Array_list = objects;
mContext = context;
}