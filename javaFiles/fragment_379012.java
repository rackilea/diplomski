public static final String VALUE = "value";

if (getIntent().getExtras() != null) {
  String activityFrom = getIntent().getStringExtra(TAG_ACTIVITY_FROM);
  int value = getIntent().getIntExtra(VALUE, -1);
}