private TextView tvContent;

    public MyMarkerView (Context context, int layoutResource) {
        super(context, layoutResource);

        tvContent = (TextView) findViewById(R.id.tvContent);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        tvContent.setText("my value " + e.getY()));             
        super.refreshContent(e, highlight); // <----- IMPORTANT

    }

}