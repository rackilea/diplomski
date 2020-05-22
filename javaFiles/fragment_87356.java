holder.itemView.setOnClickListener(v -> {
    int previousExpandedPosition = mExpandedPosition;
    mExpandedPosition = isExpanded ? -1 : position;

    if (previousExpandedPosition != -1) {
        notifyItemChanged(previousExpandedPosition);
    }
    if (mExpandedPosition != -1) {
        notifyItemChanged(mExpandedPosition);
    }
});