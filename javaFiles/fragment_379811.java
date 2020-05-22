public static  class RankViewHolder extends RecyclerView.ViewHolder {

    View mView;
    TextView rankPosition;
    public RankViewHolder(View itemView) {
       super(itemView);
       mView = itemView;

        rankPosition = (TextView) mView.findViewById(R.id.rankPosition);

    }


 @Override
 protected void populateViewHolder(RankViewHolder viewHolder, Rank model,int position) {


                viewHolder.setName(model.getName());
                viewHolder.setRuns(model.getRuns());
                viewHolder.setThumbImage(model.getThumbImage(), getApplicationContext());
                // Getting positions here
                viewHolder.rankPosition.setText(String.valueOf(position));
        }