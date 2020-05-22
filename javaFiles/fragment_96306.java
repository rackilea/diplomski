@Override
public void setAdapter(ListAdapter adapter) {
    if (adapter instanceof CustomAdapter) {
        this.adapter = (CustomAdapter adapter)
    } else {
        throw new IllegalArgumentException("adapter must be an instance of CustomAdapter");
    }
}