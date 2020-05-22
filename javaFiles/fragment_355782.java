public Object instantiateItem(View collection, int position) {

    LayoutInflater inflater = (LayoutInflater) collection.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    View view = null;
    switch (position) {
    case 0:
        view = inflater.inflate(R.layout.main_pg0, null);
        TextView valueTV = new TextView(getActivity());
        valueTV.setText("hallo hallo");
        valueTV.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT));
        ((ViewGroup)view).addView(valueTV);
        break;
    case 1:
        view = inflater.inflate(R.layout.main_pg1, null);
        // or perhaps better for readability: build the layout in a different method, passing in the root
        buildSecondPageLayout(view);
        break;
    case 2:
        view = inflater.inflate(R.layout.main_pg2, null);
        buildThirdPageLayout(view);
        break;
    }

    return view;
}