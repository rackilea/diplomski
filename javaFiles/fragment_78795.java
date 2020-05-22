public View getViewByPosition(int pos, GridView gridView) {
   final int firstListItemPosition = listView.getFirstVisiblePosition();
   final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

   if (pos < firstListItemPosition || pos > lastListItemPosition ) {
       return gridView.getAdapter().getView(pos, null, listView);
   } else {
       final int childIndex = pos - firstListItemPosition;
       return gridView.getChildAt(childIndex);
   }
}