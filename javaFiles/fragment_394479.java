DisplayMetrics metrics = new DisplayMetrics();
    ExpandableListView expList = getExpandableListView();

    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    int width = metrics.widthPixels;
    //this code for adjusting the group indicator into right side of the view
    expList.setIndicatorBounds(width - GetDipsFromPixel(50), width - 

    public int GetDipsFromPixel(float pixels)
    {
        // Get the screen's density scale
        final float scale = getResources().getDisplayMetrics().density;
        // Convert the dps to pixels, based on density scale
        return (int) (pixels * scale + 0.5f);
    }