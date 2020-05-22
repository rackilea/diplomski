private void addCloud(int imageResId, int topMarginResId) {
        RelativeLayout mainLayout = (RelativeLayout) findViewById(R.id.mainLayout);

        ImageView cloud = new ImageView(this);
        int height = (int) getResources().getDimension(R.dimen.cloud_height);
        int width = (int) getResources().getDimension(R.dimen.cloud_width);
        RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams(width, height);
        param.topMargin = (int) getResources().getDimension(topMarginResId);

        cloud.setImageResource(imageResId);
        mainLayout.addView(cloud, param);
    }