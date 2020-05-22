public class SpinnerAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;

    public List<String> strings;

    public SpinnerAdapter(Context context, List<String> strings) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);

        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings != null ? strings.size() : 0;
    }

    @Override
    public String getItem(int position) {
        return strings != null ? strings.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(R.layout.spinner_item, parent, false);
        }

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = inflater.inflate(R.layout.spinner_dropdown_item, parent, false);
        }

        return convertView;
    }
}