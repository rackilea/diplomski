public class MDCListener implements ServletRequestListener {
  public void requestInitialized(ServletRequestEvent e) {
    YourUtilityClass.request((HttpServletRequest)e.getServletRequest());
  }

  public void requestDestroyed(ServletRequestEvent e) {
    YourUtilityClass.tearDown((HttpServletRequest)e.getServletRequest());
  }
}