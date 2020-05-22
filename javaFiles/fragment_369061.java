grid1.addBodyScrollHandler(new BodyScrollHandler() {
    @Override
    public void onBodyScroll(BodyScrollEvent event) {
      grid2.getView().getScroller().scrollTo(ScrollDirection.TOP, event.getScrollTop());
    }
  });
  grid2.addBodyScrollHandler(new BodyScrollHandler() {
    @Override
    public void onBodyScroll(BodyScrollEvent event) {
      grid1.getView().getScroller().scrollTo(ScrollDirection.TOP, event.getScrollTop());
    }
  });