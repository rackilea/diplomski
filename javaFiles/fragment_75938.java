public MobileArrayAdapter(Context context, List<item> markers) {
    super(context, R.layout.list_item);
    this.context = context;
    this.markers = markers;
    this.imageLoader = new ImageLoader(context.getApplicationContext());
}