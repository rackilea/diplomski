ActorRef subSocket = ZeroMQExtension.get(getContext().system())
            .newSubSocket(null, new Listener(getSelf()), new Subscribe("health"));

    @Override
    public void preStart() {
        super.preStart();

        subSocket.tell(new Connect("tcp://127.0.0.1:1237"));
        subSocket.tell(new Connect("tcp://127.0.0.1:1238"));
    }