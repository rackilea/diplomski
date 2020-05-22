for (int i = chosenIndex; i < topTenSongs.length -1; i++) {
    topTenSongs[i] = topTenSongs[i+1];
    if(topTenSongs[i+1].getTitle().equals("Macarena (Bayside Boys Remix")){
        chosenIndex = i+1;
        String iteration = topTenSongs[i+1].getTitle();
    }
}