public List<Map<String, String>> getPlaylist() {
    File home=Environment.getExternalStorageDirectory();
    return getPlaylist (home);
}

public List<Map<String, String>> getPlaylist(File root) {
    List<Map<String, String>> songsList = new ArrayList<>();
    if (root.listFiles(new FileExtensionFilter()).length > 0) {
        Log.d(Variables.DEBUGTAG, "Filter Files=-->" + home.listFiles().length);
        for (File file : root.listFiles(new FileExtensionFilter())) {
            HashMap<String, String> song = new HashMap<String, String>();
            song.put("songTitle", file.getName().substring(0, (file.getName().length() - 4)));
            song.put("songPath", file.getPath());
            Log.d(Variables.DEBUGTAG, "Reading Files");

            // Adding each song to SongList
            songsList.add(song);

        }
    }
    for (File file : root.listFiles()) {
        if (file.isDirectory ()) {
            songsList.addAll(getPlaylist(file));
        }
    }

    return songsList;
}