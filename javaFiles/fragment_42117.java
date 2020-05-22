enum State {
    S0, S1
}
private State state = State.S0;
public void messageReceived(
        ChannelHandlerContext ctx, MessageEvent e) {
    switch(state) {
    case S0:
        // read object from channel and write appropriate response
        e.getChannel().write("HELO");  // writes are asynchronous 
        state = State.S1;
        break;
    case S1:
        // same as S0
        e.getChannel().write("DONE");
        break;
    }
}