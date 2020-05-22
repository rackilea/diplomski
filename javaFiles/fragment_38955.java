// inside your activity or fragment where you're initializing RecyclerView
recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false) {
      @Override
      public void layoutDecoratedWithMargins(@NonNull View child, int left, int top, int right, int bottom) {
          // calculate available space in recyclerView
          int offset = getHeight() - getPaddingTop() - getPaddingBottom();
          // subtract height of item being laid out
          offset -= bottom - top;
          // lay out item lower than usual
          super.layoutDecoratedWithMargins(child, left, top + offset, right, bottom + offset);
      }
});