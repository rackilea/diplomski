public static void setActionbarTitle(Activity act, String title){
    ActionBar actionBar = act.getActionBar();

    actionBar.setDisplayShowCustomEnabled(true);
    actionBar.setDisplayShowTitleEnabled(false);

    LayoutInflater inflator = (LayoutInflater) act.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View v = inflator.inflate(R.layout.actionbar_title_layout, null);

    TextView tv = (TextView) v.findViewById(R.id.tv_actionbar_title);
    tv.setText(title);
    tv.setTextColor(Color.WHITE);

    actionBar.setCustomView(v);
}