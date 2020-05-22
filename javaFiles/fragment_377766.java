try {
    Session sess = getSession();
    WebSocketContainer container = sess.getContainer();

    // Need to cast the container to Jetty's LifeCycle
    if(container != null && container instanceof LifeCycle) { 
        Logger.debug("Stopping Jetty's WebSocket Client");
        ((LifeCycle) container).stop(); 
    }

    sess.close();
} catch (Exception e) {
    Logger.error(e);
}