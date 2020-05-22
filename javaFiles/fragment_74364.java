categoryListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
        @Override
        public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

            if(categoryListAdapter.getChildrenCount(groupPosition) == 0){
                Intent intent = new Intent(CategoryList.this, ItemEditorActivity.class);

                String text = categoryListAdapter.getGroupText(groupPosition);
                intent.putExtra("GROUP_POSITION", text);
                Toast.makeText(CategoryList.this, "Group Position: " + text, Toast.LENGTH_LONG).show();
                startActivity(intent);
            }

            return false;
        }
    });