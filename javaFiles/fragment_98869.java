@Override
public View getView(int position, View convertView, ViewGroup parent) {

    if (convertView == null) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.individual_notelist, parent, false);            
        convertView = view;
    }

    TextView textView = (TextView) view.findViewById(R.id.notes_);
        String note_ = notes.get(position).getNote();
        if (note_.length() < 40){
            textView.setText(note_);
        }
        else {
            textView.setText(note_.substring(0, Math.min(note_.length(), 40)) + " ...");
        }
     return convertView;
}