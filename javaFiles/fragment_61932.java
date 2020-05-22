@Override
protected void onResume() {
    super.onResume();
    allArtists = databasehandler.getAllArtists();

    // Clear the list
    artistName.clear();

    if (allArtists.size() > 0) {
        for (int i = 0; i < allArtists.size(); i++) {
            ArtistModel artistModel = allArtists.get(i);
            artistName.add(artistModel.getArtistName());
        }
    }

    adapter.notifyDataSetChanged();
}