@Override
public int getViewTypeCount() {
    return 2;
}

@Override
public int getItemViewType(int position) {
    return this.getItem(position).getType();
}

@Override
public boolean isEnabled(int position) {
    return getItem(position).isEnabled();
}