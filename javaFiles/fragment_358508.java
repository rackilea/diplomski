for (int i = chosenIndex; i < topTenSongs.length; i++) {
    if(i == topTenSongs.length-1) {
        topTenSongs[i] = null; //set last element to null
    } else {
        topTenSongs[i] = topTenSongs[i+1];
    }
}