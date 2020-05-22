public class CustomViewHolder extends RecyclerView.ViewHolder {


        TextView tv_desc, tv_title;

        public PlanetViewHolder(View itemView) {
            super(itemView);

            tv_desc = (TextView) itemView.findViewById(R.id.tv_desc);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

            //your code of on click
                }
            });
        }
    }