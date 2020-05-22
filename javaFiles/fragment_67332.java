@Override
public Game call(RxMessage<byte[]> gameRawReply, RxMessage<byte[]> t1) {

    switch(game_model) {
        case SINGLE: {
            return singleGames.get(0);
        }
    }
}