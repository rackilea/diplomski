// Filter Class
    public ArrayList<HashMap<String, String>> filter(String searchString) {
        searchString = searchString.toLowerCase(Locale.getDefault());

    songsList.clear();
    songsList = getPlayList();

    //searchString is empty, so show all songs in results
    if (searchString.length() == 0) {

        if (filteredSongsList != null){
            filteredSongsList.clear();
        }
        filteredSongsList = songsList;
    }

    //only return songs that match the search string
    else {

        if (filteredSongsList != null){
            filteredSongsList.clear();
        }

        for (HashMap<String, String> song : songsList) {
            if (song != null) {
                String songTitle = song.get("songTitle");
                if (songTitle.toLowerCase().contains(searchString)) {
                    filteredSongsList.add(song);
                }
            }
        }
    }

    return filteredSongsList;
}