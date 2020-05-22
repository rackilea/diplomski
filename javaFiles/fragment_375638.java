class Feed {
    String mComment;
    Drawable mDrawable;
    List<Feed> mAlbum;

    Feed(Drawable drawable) {
        mDrawable = drawable;
    }

    Feed(List<Feed> album) {
        mAlbum = album;
    }

    Feed(String comment) {
        mComment = comment;
    }

    int getFeedType() {
        if (mDrawable != null) {
            return FEED_IS_IMAGE;
        }
        if (mAlbum != null) {
            return FEED_IS_ALBUM;
        }
        return FEED_IS_COMMENT;
    }

    final static int FEED_IS_COMMENT = 1;
    final static int FEED_IS_IMAGE = 2;
    final static int FEED_IS_ALBUM = 3;
}