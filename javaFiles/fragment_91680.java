public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private static final String KEY_ALBUM = "KEY_ALBUM";
    private static final String KEY_COUNT = "KEY_COUNT";
    private static final String KEY_PATH = "KEY_PATH";

    private itemClickInterface clickInterface;
    //private List<String> data;
    private ArrayList<HashMap<String, String >> data;

//    public AlbumAdapter(itemClickInterface clickInterface, List<String> data) { // Forget about this if your data is not an array of Strings.
//    public AlbumAdapter(itemClickInterface clickInterface, ArrayList<HashMap< String, String >> data) { // Forget about this if you're not ready to pass an onclick interface
    public AlbumAdapter(ArrayList<HashMap< String, String >> data) {
        this.data = data;
//        this.clickInterface = clickInterface; //Simply ignore since you're not passing an interface of clicklister
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        try {
            final String data_for_albums = this.data.get(position).get(KEY_ALBUM);
            final String data_for_counts = this.data.get(position).get(KEY_COUNT);
            final String data_for_paths = this.data.get(position).get(KEY_PATH);

            holder.gallery_title.setText(data_for_albums);
            holder.gallery_count.setText(data_for_counts);

            Glide.with(activity)
                    .load(new File(data_for_paths)) // Uri of the picture
                    .into(holder.galleryImage);



            /*
            * You can modify this as you want.
            * */
//            holder.galleryImage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    clickInterface.click(data_for_paths); // This depends on you.
//                }
//            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    /*--------------------------------------------------------------------------------------
     |                          GET REFERENCES TO VIEWS HERE
     *--------------------------------------------------------------------------------------*/
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView galleryImage;
        TextView gallery_count, gallery_title;

        ViewHolder(View itemView) {
            super(itemView);
            galleryImage = itemView.findViewById(R.id.galleryImage);
            gallery_count = itemView.findViewById(R.id.gallery_count);
            gallery_title = itemView.findViewById(R.id.gallery_title);
        }
    }
}