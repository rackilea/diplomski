Button doneBtn = (Button)rowView.findViewById(R.id.task_row_done_btn);
doneBtn.setTag(values.get(position).getId());
doneBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        dbHelper.markAsDone(v.getTag());
    }
});