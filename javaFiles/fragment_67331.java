public rx.Observable<Game> findGame(long templateId, GameModelType game_model, GameStateType state) {

    rx.Observable<RxMessage<byte[]>> ebs = context.getGameTemplate(templateId);
    rx.Observable<RxMessage<byte[]>> gameObs = context.findGame(templateId, state);

    return Observable.zip(gameObs, ebs, new Func2<RxMessage<byte[]>, RxMessage<byte[]>, Game>() {

        @Override
        public Game call(RxMessage<byte[]> gameRawReply, RxMessage<byte[]> t1) {

            Game game = null;

            switch(game_model) {
                case SINGLE: {
                    game = singleGames.get(0);
                }
            }

            return game;
        }
    });
}