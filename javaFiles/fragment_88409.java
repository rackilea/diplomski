private ArrayList<Bitmap> champions;
private GridView imageGridview;
...
...
imageGridview = (GridView) findViewById(R.id.my_grid_view);
champions = db.getChamp_splash();
if (champions != null) {  // if the bitmaps were found
    ImageGridViewAdapter adapter = new ImageGridViewAdapter(this, bitmaps, columnWidth);   // using custom adapter for showing images
    // columnWidth is just some int value representing image width
    imageGridview.setAdapter(adapter);
}