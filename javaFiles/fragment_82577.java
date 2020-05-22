private Agent agent;
private Thread controller = new Thread() {
    agent = new Agent();
    // ...
    agent.getParameter(); // should not throw a NullPointerException
}