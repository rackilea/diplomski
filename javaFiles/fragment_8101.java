@Override
public void onBindViewHolder(MyViewHolder holder, int position) {
    Contact contact = contactArrayList.get(position);
    holder.name.setText(contact.getmFullName());
    holder.checkBox.setChecked(contact.getSelected());
}