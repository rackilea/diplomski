@Override
    public void onBindViewHolder(MyHolder holder, final int position) {

        holder.textViewModel.setText(training.get(position).getExercise());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v) {
                if (FirstActivity.MONDAY_WAS_RUNNING)

                {Intent intent = new Intent(c, DetailActivity.class);

                    intent.putExtra(KEY_MON, VALUE_MON);
                    intent.putExtra("id", training.get(position).getId());
                    intent.putExtra("exercise", training.get(position).getExercise());
                    intent.putExtra("weight", training.get(position).getWeight());
                    intent.putExtra("repeat", training.get(position).getRepeat());
                    intent.putExtra("series", training.get(position).getSeries());

                    c.startActivity(intent);

                } else if (FirstActivity.TUESDAY_WAS_RUNNING)

                {Intent intent2 = new Intent(c, DetailActivity.class);

                    intent2.putExtra(KEY_TUE, VALUE_TUE);
                    intent2.putExtra("id", training.get(position).getId());
                    intent2.putExtra("exercise", training.get(position).getExercise());
                    intent2.putExtra("weight", training.get(position).getWeight());
                    intent2.putExtra("repeat", training.get(position).getRepeat());
                    intent2.putExtra("series", training.get(position).getSeries());

                    c.startActivity(intent2);
                }}});}