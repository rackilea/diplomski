@Override
public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

    View itemView = viewHolder.itemView;
    //**********************
    TextView txt = itemView.findViewById(R.id.tv_usernameStatsAdapter);
    //*******************************
    int itemHeight = itemView.getHeight();

    boolean isCancelled = dX == 0 && !isCurrentlyActive;

    if (isCancelled) {
        clearCanvas(c, itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        return;
    }

    mBackground.setColor(backgroundColor);
    // ****************** 
    mBackground.setBounds(itemView.getRight() + (int) dX + txt.getPaddingStart(), itemView.getTop() + txt.getPaddingTop(), itemView.getRight() - txt.getPaddingEnd(), itemView.getBottom() - txt.getPaddingBottom());
    //**************************
    mBackground.draw(c);

    int deleteIconTop = itemView.getTop() + (itemHeight - intrinsicHeight) / 2;
    int deleteIconMargin = (itemHeight - intrinsicHeight) / 2;
    int deleteIconLeft = itemView.getRight() - deleteIconMargin - intrinsicWidth;
    int deleteIconRight = itemView.getRight() - deleteIconMargin;
    int deleteIconBottom = deleteIconTop + intrinsicHeight;


    deleteDrawable.setBounds(deleteIconLeft, deleteIconTop, deleteIconRight, deleteIconBottom - 6);
    deleteDrawable.draw(c);

    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);


}