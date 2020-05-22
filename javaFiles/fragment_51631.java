@Override
public int getItemPosition(Object item) {
    Fragment fragment = (Fragment) item;
    String title = fragment.getArguments().getString("TAG");
    int position = tabs.indexOf(title);
    if (position >= 0) {
        return position;
    } else {
        return POSITION_NONE;
    }