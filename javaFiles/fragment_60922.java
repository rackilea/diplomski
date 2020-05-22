final MyAdapter myAdapter = new MyAdapter(this, headings, childList);
    expandableListView.setAdapter(myAdapter);
    checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            myAdapter.filter("Saturn", isChecked);
        }
    });