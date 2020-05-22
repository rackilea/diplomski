@Override
    public void onBindViewHolder(MyHolder holder, final int position) {
           holder.textViewModel.setText(training.get(position).getExercise());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v) {
                Intent intent = new Intent(c, DetailActivity.class);
                if (FirstActivity.MONDAY_WAS_RUNNING) {
                    intent.putExtra(KEY_MON, VALUE_MON);
                } else {
                    intent.putExtra(KEY_TUE, VALUE_TUE);
                }                       
                intent.putExtra("id", training.get(position).getId());
                intent.putExtra("exercise", training.get(position).getExercise());
                intent.putExtra("weight", training.get(position).getWeight());
                intent.putExtra("repeat", training.get(position).getRepeat());
                intent.putExtra("series", training.get(position).getSeries());
                c.startActivity(intent);
        });
    }