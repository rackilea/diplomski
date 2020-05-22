GridLayoutManager manager = new GridLayoutManager(this, 10); // 3 cols of 3 + 1 col of 1
manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
  @Override
  public int getSpanSize(int position) {
    if (position % 4 == 3)
       return 1; // Fourth column is 1x
    else
       return 3; // Remaining columns are 3x
  }
});
recyclerView.setLayoutManager(manager);