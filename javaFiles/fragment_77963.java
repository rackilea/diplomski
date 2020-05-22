when(layer.createNewPlaylist(eq("playlist1"), any(UUID.class))).then(playlistWithSameUUID);

public Answer<OnDemandPlaylist> playlistWithSameUUID() {
    return new Answer<OnDemandPlaylist>() {
                 public OnDemandPlaylist answer(InvocationOnMock invocation) {
                     Object[] args = invocation.getArguments();
                     return new OnDemandPlaylist("playlist1", "", (UUID)args[1]);
                     }
                 };
}