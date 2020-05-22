class ViewHolderEntry extends RecyclerView.ViewHolder implements View.OnClickListener
        {
            private TextView nameTextView;
            private TextView descriptionTextView;
            private TextView dueTextView;

            ViewHolderEntry(View itemView)
            {
                super(itemView);

                this.nameTextView = itemView.findViewById(R.id.nameView);
                this.descriptionTextView = itemView.findViewById(R.id.descriptionView);
                this.dueTextView = itemView.findViewById(R.id.dueView);
                itemView.setOnClickListener(this);
            }


            @Override
            public void onClick(View view) {
                clickListener.OnItemClicked(itemView,getAdapterPosition());
            }
        }