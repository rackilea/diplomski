public class ContactListAdapter extends ListAdapter<String> {

 private final List contacts;

//Call to super to set up the adapter
  public ContactListAdapter(Context context, List<Contact> contacts) {
    super(context, R.layout.rowlayout, values);
    this.contacts = contacts;
}

@Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    //Get your View
    View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

    //create the emelements you want to add to list
    TextView textView = (TextView) rowView.findViewById(R.id.label);
    textView.setText(contacts.get(position).getId())

    return rowView
}
}