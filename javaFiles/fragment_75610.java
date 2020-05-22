public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.ViewHolder> {

    private Context context;
    private ArrayList<NewsData> newsData;

    public HomeRecyclerAdapter (ArrayList<NewsData> newsData, Context context) {
       this.newsData = newsData;
       this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView itemTitle;
        public TextView holeText;

        public ViewHolder(final View itemView) {
            super(itemView);
            itemTitle = (TextView) itemView.findViewById(R.id.title_cView);
            holeText = (TextView) itemView.findViewById(R.id.text);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context = itemView.getContext();
                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_cardviewhome, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        NewsData thisNewsData = newsData.get(position);

        holder.itemTitle.setText(thisNewsData.getItemTitle());
        holder.holeText.setText(thisNewsData.getHoleText());
    } 

    @Override
    public int getItemCount() {
        return newsDataArray.size();
    }
}