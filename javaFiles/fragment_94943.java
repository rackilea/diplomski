public int selectedPosition  = -1   
public class StarCountHolder extends RecyclerView.ViewHolder {
    ImageView starImage;
    TextView actorName,counts;
    StarCount modelCount;
    public StarCountHolder(View itemView) {
        super(itemView);
        starImage = (ImageView) itemView.findViewById(R.id.starCountIv);
        actorName = (TextView) itemView.findViewById(R.id.acterName);
        counts = (TextView) itemView.findViewById(R.id.counts);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = getLayoutPosition());
                notifyDatasetChanged();
            }
        });
    }
}