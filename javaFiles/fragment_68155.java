public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.RecyclerViewHolder> {

    private static final int TYPE_EPISODE = 0; // it's possible to show multiple types recycler

    List<Episode> episodesList = new ArrayList();

    private Context context;
    private AdapterOnClickHandler mClickHandler;

    public interface AdapterOnClickHandler {
        void onClick(Episode episode);
    }

    public EpisodeAdapter(AdapterOnClickHandler clickHandler) {
        mClickHandler = clickHandler;
    }

    public void setClickListener(AdapterOnClickHandler callback) {
        mClickHandler = callback;
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView title;

        public RecyclerViewHolder(View view) {
            super(view);
            title = (TextView)itemView.findViewById(R.id.title);
            view.setOnClickListener(this);
        }

        public void setData(Episode episode) {
            title.setText(episode.title);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Episode episode = episodesList.get(adapterPosition);
            mClickHandler.onClick(episode);
        }

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.series_list_item, viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, final int position) {
       holder.setData(episodesList.get(position));
    }

    @Override
    public int getItemCount() {
        return episodesList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_EPISODE;
    }

    public void setSeriesData(ArrayList<Series> seriesData) {
        episodesList.clear();
        for (Series s : seriesData) {
            episodesList.addAll(Episode.createEpisodeList(s.getEpisodes()));
        }
        notifyDataSetChanged();
    }
}