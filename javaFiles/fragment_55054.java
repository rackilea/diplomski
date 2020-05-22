return new JettyServerCustomizer() {

        @Override
        public void customize(Server server) {
            String jetty_home = System.getProperty("jetty.home","..");
            WebAppContext webapp = new WebAppContext();
            webapp.setContextPath("/");
            webapp.setWar(jetty_home+"/webapps/sample.war");
            webapp.setHandler(server.getHandler());
            server.setHandler(webapp);
        }
    };