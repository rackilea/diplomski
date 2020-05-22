@Override
public View getView(int position, View convertView, ViewGroup parent) {
    LinearLayout layout = new LinearLayout(ctx);
    layout.setOrientation(LinearLayout.VERTICAL);
    layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
            LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

    TextView tv = new TextView(ctx);
    TextView tv2 = new TextView(ctx);
    tv.setLayoutParams(lparams);
    tv2.setLayoutParams(lparams);
    tv.setText(String.valueOf(items[position]));
    tv2.setText(String.valueOf(stuff[position]));
    layout.addView(tv);
    layout.addView(tv2);
    return layout;
}