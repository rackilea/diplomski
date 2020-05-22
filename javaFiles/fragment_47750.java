protected void onBindViewHolder(UsersViewHolder holder, int position, User model) {
                    holder.bind(model);
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                         public void onClick(View v) {
                             Log.d("viewholder", " " + holder.getAdapterPosition());
                             Log.d("viewholder", " " + model.getUsername());

                         }
                    });
     }