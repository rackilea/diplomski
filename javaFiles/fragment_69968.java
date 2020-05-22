listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 String bookNo = stringArrayList.get(position).getBookNo();
                 Log.e("BookNo : ", bookNo);
            }
        });