public class RecyclerViewHolderPreviousPosts extends RecyclerView.ViewHolder implements View.OnClickListener {
        // View holder for gridview recycler view as we used in listview
        public TextView createdAt;
        public ImageView uploadedImage;
        public TextView caption;
        TextView number_of_likes;
        TextView number_of_comments;
        TextView number_of_tags;
        public ImageView comments;
        public RelativeLayout imageContainer;


    RecyclerViewHolderPreviousPosts(View view) {
        super(view);
        // Find all views ids
        this.createdAt = (TextView) view
                .findViewById(R.id.created_date);
        this.uploadedImage = (ImageView) view
                .findViewById(R.id.image);
        this.caption = (TextView) view
                .findViewById(R.id.caption_post);
        this.number_of_likes = (TextView) view
                .findViewById(R.id.number_of_likes);
        this.number_of_comments = (TextView) view
                .findViewById(R.id.number_of_comments);
        this.number_of_tags = (TextView) view
                .findViewById(R.id.number_of_tags);
        this.comments = (ImageView) view
                .findViewById(R.id.comments_image);
        this.imageContainer = (RelativeLayout) view
                .findViewById(R.id.image_container);
        view.setOnClickListener(this);
    }

    void bind(PreviousPostsDataModel model1, final int position) { ....
        model = previousPostsList.get(position);
        getTagInformation();
....}

    private void getTagInformation() {
        for (int o = 0; o < model.getTagSize(); o++) {
            tag = new TextView(App.getContext());
            tag.setX(Float.parseFloat(model.getXpoints(o)));
            tag.setY(Float.parseFloat(model.getYpoints(o)));
            Log.e("x", "" + tag.getX());
            Log.e("y", "" + tag.getY());
            tag.setText(model.getTagName(o));
            tag.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            tag.setMaxLines(1);
            tag.setTextSize(11);
            tag.setClickable(true);
            tag.setHintTextColor(Color.WHITE);
            tag.setTextColor(Color.WHITE);
            tag.setBackgroundResource(R.drawable.tags_rounded_corners);
            imageContainer.addView(tag);
            tags.add(tag);
        }
    }

    @Override
    public void onClick(View v) {
        if (count == 0) {
            for (int i = 0; i < tags.size(); i++) {
                tags.get(i).setVisibility(View.INVISIBLE);
            }
            count = 1;
        }
        else {
            for (int j = 0; j < tags.size(); j++) {
                tags.get(j).setVisibility(View.VISIBLE);
            }
            count = 0;
        }
    }
}