//listview item clicks
    view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //code later
            Intent intent = new Intent(mContext, NewActivity.class);
            intent.putExtra("position", getViewTypeCount());
            intent.putExtra("actionBarTitle", modellist.get(i).getTitle());
            intent.putExtra("contentTv", modellist.get(i).getDesc());
            **intent.putExtra("brandNewDesc", modellist.get(i).getBrandNewDesc());**

            mContext.startActivity(intent);


        }
    });