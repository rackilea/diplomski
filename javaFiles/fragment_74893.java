public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
        convertView = LayoutInflater.from(this)
            .inflate(R.layout.<your_layout>, parent, false);
    }

    ScoringInfo item = this.getItem(position);

    CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkbox_id);
    checkBox.setTag("score", item.max_points);
    checkBox.setOnClickListener(this);
}

public void onClick(View view) {
    if (view instanceof CheckBox) {
        boolean checked = ((CheckBox) view).isChecked();
        int score = view.getTag("score");
        // do the rest
    }
}