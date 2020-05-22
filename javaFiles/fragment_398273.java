ArrayList<MediaItem> mediaItems = new ArrayList<MediaItem>(); // Legal
ArrayList<Song> songs = mediaItems; // Illegal; let's imagine it's legal for a moment
// Note that songs and mediaItems are the same list
songs.add(new Song());         // This is perfectly fine
Song firstSong = songs.get(0); // That's OK - it's a Song
mediaItems.add(new Video());   // This is perfectly fine, too
// However, the addition above also modifies songs: remember, it's the same list.
// Now let's get the last object from songs
Song lastSong = songs.get(1);  // Wait, that's not a Song, it's a Video!!!