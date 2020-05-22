@Override
public Object getItem(int position) {
    if (result == null) {
        return null;
    }

    return result.get(position);
}