public View getView(int position, View convertView, ViewGroup parent) {
    CheckedTextView ctv = null;
    if (convertView != null) {
        ctv = (CheckedTextView)convertView.findViewById(android.R.id.text1);
    }
    if (ctv != null) {