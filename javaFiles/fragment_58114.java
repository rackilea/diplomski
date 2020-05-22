for (int i = 0; i< questions.size(); i++) {

    View view1 = View.inflate(Checklist.this, R.layout.question, null);
    TextView myText = (TextView) view1.findViewById(R.id.questiontext);
    checkbox = (CheckBox) view1.findViewById(R.id.checkBox);
    checkbox.setTag(String.valueOf(i));
    layout.addView(view1);
    myText.setText(questions.get(i).question);

    checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
           //check which checbox is checked
           String tag= (String)buttonView.getTag();
        }
    });
}