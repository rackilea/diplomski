public class Content {
    boolean isVideo;

    public Content(boolean isVideo) {
        this.isVideo = isVideo;
    }

    public boolean isVideo() {
        return isVideo;
    }

    public void setVideo(boolean video) {
        isVideo = video;
    }
}



public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final int IS_VIDEO = 0;
    private static final int IS_IMAGE = 1;
    private List<Content> items;

    public CustomAdapter(List<Content> items) {
        this.items = items;
    }

    public void refresh(List<Content> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(items.get(position).isVideo){
            return IS_VIDEO;
        }else{
            return IS_IMAGE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == IS_VIDEO){
            return new VideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_video, parent, false));
        }
        else {
            return new ImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_image, parent, false));
        }
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ImageViewHolder){
            onBindImageViewHolder((ImageViewHolder) holder, position);
        }
        else{
            onBindVideoViewHolder((VideoViewHolder) holder, position);
        }
    }

    private void onBindImageViewHolder(ImageViewHolder holder, int position) {

    }

    private void onBindVideoViewHolder(VideoViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ImageViewHolder extends RecyclerView.ViewHolder {

        public ImageViewHolder(View itemView) {
            super(itemView);
        }

    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        public VideoViewHolder(View itemView) {
            super(itemView);
        }

    }
}