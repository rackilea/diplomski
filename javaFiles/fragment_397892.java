@Override
public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder selected, List<RecyclerView.ViewHolder> dropTargets, int curX, int curY) {
    for (RecyclerView.ViewHolder target : dropTargets) {
            int top = curY - selected.itemView.getTop();
            int bottom = curY + selected.itemView.getHeight();
            int diff;
            if (top < 0) {
                diff = target.itemView.getTop() - curY;
            } else {
                diff = target.itemView.getBottom() - bottom;
            }
            if (Math.abs(diff) <= 100) {
                adapter.onItemHover();
            } else {
                adapter.onItemHoverFinish();
            }
    }
    return super.chooseDropTarget(selected, dropTargets, curX, curY);
}