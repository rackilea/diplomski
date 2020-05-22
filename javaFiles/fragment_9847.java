public class Eventlist extends ArrayAdapter<Event>{

    private static final String LINE_SEPARATOR = System.getProperty ("line.separator");

    public Eventlist(Context context, List<Event> events) {
        super(context, R.layout.list_event, events);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView = view;
        ViewHolder holder;

        if (rowView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            rowView = inflater.inflate(R.layout.list_event, null, true);
            holder.txtContent = (TextView) rowView.findViewById(R.id.belisttitle);
            rowView.setTag(holder);
        } else {
            holder = (ViewHolder) rowView.getTag();
        }

        Event event = getItem(position);
        StringBuilder line = new StringBuilder(position+1)
            .append(" . ")
            .append(event.getTitle())
            .append(LINE_SEPARATOR)
            .append(event.getDescription());
        holder.txtContent.setText(line);

        return rowView;
    }

    static class ViewHolder {
        private TextView txtContent;
    }

}