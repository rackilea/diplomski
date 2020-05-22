public ServerActivityArrayAdapter(Context context, int layout, List<Server> servers, int defServer) {
    super(context, layout, servers);
    ListArrays listArrays = new ListArrays(context);
    this.layout = layout;
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    mSelectedPosition = defServer;
}