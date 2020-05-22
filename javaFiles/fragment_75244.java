public void bindView(View view, Context context, Cursor cursor) {
    ViewHolder viewHolder = (ViewHolder) view.getTag();

    final long id = cursor.getLong(cursor.getColumnIndex(DoctorEntry._ID));
    String firstName = cursor.getString(cursor.getColumnIndex(DoctorEntry.COLUMN_FIRSTNAME));
    String lastName = cursor.getString(cursor.getColumnIndex(DoctorEntry.COLUMN_LASTNAME));
    String suffix = cursor.getString(cursor.getColumnIndex(DoctorEntry.COLUMN_SUFFIX));

    viewHolder.nameView.setText(firstName + " " + lastName + ", " + suffix);

    viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked){
                selectedDoctorId = id;
            } else{
                selectedDoctorId = 0;
            }
            notifyDataSetChanged();
        }
    });
}