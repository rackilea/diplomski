mDrawerListView.post(new Runnable() {
        @Override
        public void run() {
            Resources resources = getResources();
            float width = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, resources.getDisplayMetrics());
            DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) mDrawerListView.getLayoutParams();
            params.width = (int) (width);
            mDrawerListView.setLayoutParams(params);
        }
    });