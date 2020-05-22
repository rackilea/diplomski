View mOverflow;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final View decor = getWindow().getDecorView();
    decor.post(new Runnable() {
        @Override
        public void run() {
            ArrayList<View> results = new ArrayList<>();
            decor.findViewsWithText(results, "OVERFLOW",
                    View.FIND_VIEWS_WITH_CONTENT_DESCRIPTION);

            if (results.size() == 1) {
                mOverflow = results.get(0);
            }
        }
    });
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
}

private void showMenu() {
    actionbar.show();
    mOverflow.performClick();
}