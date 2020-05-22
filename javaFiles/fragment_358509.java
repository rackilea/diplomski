for (int i = 0; i < topTenSongs.length; i++) {
    if(topTenSongs[i] != null) {
        System.out.println(topTenSongs[i].getTitle());
    } else {
        System.out.println("null");
    }
}