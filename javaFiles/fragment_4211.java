Button addBtn = (Button) findViewById(R.id.add_btn);
{
    addBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            saveListInfo();
        }
    });
}