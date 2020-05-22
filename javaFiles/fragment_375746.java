public class BaseAdapterWithHiddenValue extends BaseAdapter {

    public static class Entry {

        public String name;
        public String value;
    }

    List<Entry> items = new LinkedList<Entry>();

    public void add(String name, String value) {
        Entry e = new Entry();
        e.name = name;
        e.value = value;
        items.add(e);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Entry getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        // TODO: I'm lazy, create individual list entry view here
        return null;
    }

}