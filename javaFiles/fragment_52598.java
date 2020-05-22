@Override
public Object getItem(int position) {
    if (searchList == null || searchList.isEmpty()) {
        return null;
    } else {
        return searchList.get(position);
    }
}

@Override
public long getItemId(int position) {
    return position; // Better is to return id field of data if you have
}