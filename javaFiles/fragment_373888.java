@Override
public int getItemViewType(int position) {
    Log.d(TAG, "position = " + position);
    if (locationlist == null || locationlist.size() == 0) {
        return EMPTY;
    } else {
        return NOT_EMPTY;
    }
}