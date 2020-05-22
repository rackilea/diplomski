public siliderAdapter(Food cat, String[] data, int[] icons) {

    text = data;
    imgIcon = icons;
    context = cat;
    inflater = (LayoutInflater)context.
            getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}