protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);

    String s = new String("<a href=\"http://www.facebook.com\">facebook</a>");
    Spanned sp = Html.fromHtml(s);
    String s1 = new String("<a href=\"http://www.google.com\">google</a>");
    Spanned sp1 = Html.fromHtml(s1);

    listValues = new ArrayList<>();
    listValues.add(sp);
    listValues.add(sp1);
    setListAdapter(new SpannedAdapter(this, listValues));

    ListView l = getListView();
    l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            try {
                LinearLayout linearLayout = (LinearLayout) view;
                TextView wantedView = (TextView) linearLayout.findViewById(R.id.rowTextView);
                wantedView.setClickable(true);
                wantedView.setMovementMethod(LinkMovementMethod.getInstance());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    });

}