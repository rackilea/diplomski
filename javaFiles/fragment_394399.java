/* @return an ObjectBinding of immutable TimeElapsed objects for the player */
private ObjectBinding<TimeElapsed> createElapsedBindingByBindingsAPI(
        final MediaPlayer player
    ) {
    return Bindings.createObjectBinding(
        new Callable<TimeElapsed>() {
            @Override
            public TimeElapsed call() throws Exception {
                return new TimeElapsed(player.getCurrentTime());
            }
        },
        player.currentTimeProperty()
    );
}