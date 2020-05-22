AlbumService createAlbumService(){
    return new AlbumService();
}

...

public void getAlbums(final ServiceCallback<AlbumsWrapper> albumsServiceCallback) {

    createAlbumService().fetchAlbums(new ServiceCallback<NetworkResponse>()