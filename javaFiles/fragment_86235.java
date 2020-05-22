Server server = new Server(8080);

    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    webapp.setWar("path_to_the_war_file/your_app.war");
    server.setHandler(webapp);

    server.start();
    server.join();