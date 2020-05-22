class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Feed> mNewItems = new ArrayList<>();

    RecyclerViewAdapter(List<Feed> items) {
        int i = 0;
        Feed feed;
        int feedType;
        List<Feed> album; // Run of 4 or more images in items

        // Process the incoming list to consolidate runs of 4 or more images into
        // a single Feed entry.
        while (i < items.size()) {
            feed = items.get(i);
            feedType = feed.getFeedType();
            if (feedType == Feed.FEED_IS_IMAGE && (album = getAlbum(items, i)) != null) {
                feed = new Feed(album);
                i += album.size();
            } else {
                i++;
            }
            mNewItems.add(feed);
        }
    }

    // Identify runs of 4 or more images and return an album (List<Feed>) of those images.
    private List<Feed> getAlbum(List<Feed> feedList, int offset) {
        int i = offset + 1;

        while (i < feedList.size() && feedList.get(i).getFeedType() == Feed.FEED_IS_IMAGE) {
            i++;
        }
        return (i - offset < 4) ? null : feedList.subList(offset, i);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layoutId;

        switch (viewType) {
            case Feed.FEED_IS_IMAGE:
                layoutId = R.layout.image_layout;
                break;

            case Feed.FEED_IS_ALBUM:
                layoutId = R.layout.album_layout;
                break;

            default: // comment
                layoutId = R.layout.comment_layout;
                break;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        return new ViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Feed feed = mNewItems.get(position);
        switch (getItemViewType(position)) {
            case Feed.FEED_IS_ALBUM:
                for (int i = 0; i < 4; i++) {
                    holder.mAlbumViews.get(i).setImageDrawable(feed.mAlbum.get(i).mDrawable);
                }
                holder.mAlbumImageCount.setText("+ " + (feed.mAlbum.size() - 4));
                break;

            case Feed.FEED_IS_IMAGE:
                holder.mImage.setImageDrawable(feed.mDrawable);
                break;

            default:
                holder.mComment.setText(feed.mComment);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mNewItems.get(position).getFeedType();
    }

    @Override
    public int getItemCount() {
        return mNewItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImage;
        TextView mComment;
        List<ImageView> mAlbumViews;
        TextView mAlbumImageCount;

        ViewHolder(View itemView, int viewType) {
            super(itemView);
            switch (viewType) {
                case Feed.FEED_IS_IMAGE:
                    mImage = itemView.findViewById(R.id.imageView);
                    break;

                case Feed.FEED_IS_ALBUM:
                    mAlbumViews = new ArrayList<>();
                    mAlbumViews.add((ImageView) itemView.findViewById(R.id.albumView1));
                    mAlbumViews.add((ImageView) itemView.findViewById(R.id.albumView2));
                    mAlbumViews.add((ImageView) itemView.findViewById(R.id.albumView3));
                    mAlbumViews.add((ImageView) itemView.findViewById(R.id.albumView4));
                    mAlbumImageCount = itemView.findViewById(R.id.albumView4OverlayText);
                    break;

                default: // is comment layout
                    mComment = itemView.findViewById(R.id.comment);
                    break;

            }
        }
    }
}