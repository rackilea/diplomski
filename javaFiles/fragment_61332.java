lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
adapter.changeIndex(i);//This will give you the same result of viewHolder.LL.setOnClickListener as you are doing
                //Do whatever you are doing previously
            }
        });