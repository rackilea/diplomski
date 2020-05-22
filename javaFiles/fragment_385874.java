class MyViewHolder extends RecyclerView.ViewHolder
{
        TextView name;
        ImageView profilePic;
        View mView;
        public MyViewHolder(@NonNull View itemView) 
    {
            super(itemView);
            mView = itemView;
            name = (TextView) itemView.findViewById(R.id.film_name);
            profilePic = (ImageView) itemView.findViewById(R.id.filmProfile);
        }
    }