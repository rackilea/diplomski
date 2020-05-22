@Override
public View getView(int position, View convertView, ViewGroup parent) {

    if (convertView == null) {
        holder = new ViewHolder();

        convertView = inflater.inflate(R.layout.list_row, null);
        convertView.setMinimumHeight(50);

        holder.textViewContactName = (TextView) convertView
                .findViewById(R.id.textview_contact_name);
        holder.textView_Contact_Number = (TextView) convertView
                .findViewById(R.id.textview_number);
        holder.imgViewContactImage = (ImageView) convertView
                .findViewById(R.id.imgViewContactImage);

        convertView.setTag(holder);

    } else
        holder = (ViewHolder) convertView.getTag();

    if (allContactsNumbers.size() <= 0) {
        holder.textViewContactName.setText("No Data");

    } else {
        holder = (ViewHolder) convertView.getTag();

        String name = allContactsNumbers.get(position).getName();
        holder.textViewContactName.setText(name);

        String number = allContactsNumbers.get(position).getNumber();
        holder.textView_Contact_Number.setText(number);

        Uri Uri = allContactsNumbers.get(position).getImage_Uri();
        if (Uri != null) {
            holder.imgViewContactImage.setImageURI(Uri);
        } else {
            holder.imgViewContactImage.setImageResource(R.drawable.ic_no_image);
        }

        Log.d("Contacts in Adapter", "" + name + "" + number);

    }
    return convertView;
}