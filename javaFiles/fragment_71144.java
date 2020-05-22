if (position >0) {
    if (!list.get(position).getProfession().substring(0, 1).equals
            (list.get(position - 1).getProfession().substring(0, 1))) {
        holder.icon.setVisibility(View.VISIBLE);
    }
}