Button b = new Button(context);
      b.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            myAdapter.addViewToList(new MySingleLineInList());

        }
    });