notesListView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             ImageView tickImage = view.findViewById(R.id. tickImageView);
             if(tickImage!=null){
                 tickImage.setVisibility(View.GONE);
              }
            }
        });