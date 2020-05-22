private OnClickInMyAdapterListener  myActivityInterface;

     public FeedListAdapter(Activity activity, List<FeedItem> feedItems, OnClickInMyAdapterListener  myActivityInterface ) {
            this.activity = activity;
            this.feedItems = feedItems;
            this.myActivityInterface= myActivityInterface;

        }