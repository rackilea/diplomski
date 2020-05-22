@Override
public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state){
    outRect.top = space;

    Log.e("Decor", "Parent: " + parent + " Childs: " + parent.getChildCount() + " pos: " + parent.getChildLayoutPosition(view));

    if (parent.getChildCount() == 1){
        outRect.top = 0;
    }
}