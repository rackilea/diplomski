public siliderAdapter(Context ctx, Food cat, String[] data, int[] icons) {

    text = data;
    imgIcon = icons;
    context = ctx;
    inflater = (LayoutInflater)context.
            getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}