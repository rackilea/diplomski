private View buildTab(int icon, int label) {
    LayoutInflater inflater = LayoutInflater.from(this);
    View view = inflater.inflate(R.layout.tab_button, null);
    ((ImageView) view.findViewById(R.id.tab_icon)).setImageDrawable(new StateDrawable(new Drawable[] { getResources()
          .getDrawable(icon) }));
    ((TextView) view.findViewById(R.id.tab_text)).setText(getString(label));
    return view;
}