@Autowired
private RestartEndpoint restartEndpoint;

...

Thread restartThread = new Thread(() -> restartEndpoint.restart());
restartThread.setDaemon(false);
restartThread.start();