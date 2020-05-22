public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter .MyHolder> {

      public Model getItem(int position) {
        if (position < 0 || position >= getItemCount()) {
            throw new IllegalArgumentException("Item position is out of adapter's range");
        } else if (mCursor.moveToPosition(position)) {
            return new Model (mCursor);
        }
        return null;
    }
}