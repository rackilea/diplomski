// ... SNIPPED

public LastfmArtistGetImageURL(String[] names, GridView gv, Activity activity) {
    artistsOrMbids = names;
    mGridView = gv;
    mActivity = activity;
}

@Override
protected String[] doInBackground(Object... arg0) {
    Collection<String> col = new ArrayList<String>();
    for (String nameOrMbid : this.artistsOrMbids) {
        Artist artist = Artist.getInfo(artistOrMbid, LASTFM_API_KEY);
        col.add(artist.getImageURL(ImageSize.EXTRALARGE));
    }
    return col.toArray(new String[0]);
}


// .... SNIPPED