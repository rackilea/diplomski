public static void main (String args []) throws MBWS2Exception {

    String artistName = "Imagine Dragons";
    String albumName = "Night Visions";
    String album_id = null;

    Artist artistsearch = new Artist();
    artistsearch.search(artistName);


    List<ArtistResultWs2> result = artistsearch.getFullSearchResultList();
    ArtistWs2 artist = new ArtistWs2();

    for(ArtistResultWs2 x : result){
        if(x.getArtist().toString().equals(artistName)){
            artist = x.getArtist();     
            break;
        }
    }

     artistsearch = new Artist();
     artistsearch.lookUp(artist);

     List<ReleaseGroupWs2> release_groups = artistsearch.getFullReleaseGroupList();
     ReleaseGroupWs2 releasegroup = null;


     for(ReleaseGroupWs2 x : release_groups)
         if(x.getTitle().equals(albumName)){
             releasegroup = x;
         }

     ReleaseGroup releasegroupsearch = new ReleaseGroup();
     releasegroupsearch.lookUp(releasegroup);

     List<ReleaseWs2> releases = releasegroupsearch.getFullReleaseList();

     ReleaseWs2 album = releases.get(0);

     Release releaselist = new Release();
     releaselist.lookUp(album);

     MediumListWs2 releaselist1 = releaselist.getComplete(album).getMediumList();

     List<TrackWs2> tracklist = releaselist1.getCompleteTrackList();

     System.out.println("artist: " + artist);
     System.out.println("album: " + album);
     System.out.println("title: " + tracklist.get(0).getRecording().getTitle());
     System.out.println("genre: " + tracklist.get(0).getRecording().getTags().get(0).getName());
     System.out.println("track: " + tracklist.get(0).getPosition());
     System.out.println("year: " + album.getYear());
     System.out.println("disc no.: " + releaselist1.getMedia().get(0));
     System.out.println("label: " + album.getLabelInfoString());
     System.out.println("artist sort : " + tracklist.get(0).getRecording().getArtistCreditString());
     System.out.println("comment: " + tracklist.get(0).getRecording().getDisambiguation());


}