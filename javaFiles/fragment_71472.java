@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_holder);

    final LayoutInflater li = LayoutInflater.from(this);
    final LinearLayout layout = (LinearLayout) findViewById(R.id.layout_holder);

    layout.post(new Runnable() {
        @Override
        public void run() {
            int height = layout.getMeasuredHeight();
            LinearLayoutOutlined view = (LinearLayoutOutlined) li
                .inflate(R.layout.block, null);
            view.setMinimumHeight(height);
            layout.addView(view);
        }
    });
}