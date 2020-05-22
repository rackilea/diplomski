recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
        @Override
        public void onClick(View view, int position) {
          //  String title = ((TextView) view.findViewById(R.id.title)).getText().toString();
            String title1 = ((TextView) recyclerView.findViewHolderForAdapterPosition(position).itemView.findViewById(R.id.title)).getText().toString();
            Toast.makeText(getApplicationContext(), title1, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onLongClick(View view, int position) { }
    }));