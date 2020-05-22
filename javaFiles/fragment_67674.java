JobListAdapter jobListAdapter = new JobListAdapter (...);
listView.setAdapter(jobListAdapter);

listView..setOnItemClickListener(new OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
            // TODO Auto-generated method stub

        }
    });