@Override
public int getViewTypeCount() {
    if (objects.size() > 0) {
        return objects.size();
    }
    return 1;
}

@Override
public int getItemViewType(int position) {
    return position;
}