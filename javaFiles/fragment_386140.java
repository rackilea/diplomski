public class SessionLoggingListener implements HttpSessionListener,
    HttpSessionActivationListener, Serializable {
private static final long serialVersionUID = -763785365219658010L;
private static final Logger LOG = Logger.getLogger(SessionLoggingListener.class);

public SessionLoggingListener() {
    LOG.info("SessionLoggingListener created");
}

public void sessionDidActivate(HttpSessionEvent event) {
    LOG.info("Session " + event.getSession().getId() + " activated");
}

public void sessionWillPassivate(HttpSessionEvent event) {
    LOG.info("Session " + event.getSession().getId() + " will passivate");
}

public void sessionCreated(HttpSessionEvent event) {
    final HttpSession session = event.getSession();
    LOG.info("Session " + session.getId() + " created. MaxInactiveInterval: " + session.getMaxInactiveInterval() + " s");
    session.setAttribute(this.getClass().getName(), this);
}

public void sessionDestroyed(HttpSessionEvent event) {
    LOG.info("Session " + event.getSession().getId() + " destroyed");
    event.getSession().removeAttribute(this.getClass().getName());
}

}