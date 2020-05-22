public class MyListener implements HttpSessionListener {

   public void sessionCreated(HttpSessionEvent event) {
      String value = event.getSession().getServletContext().getInitParameter(paramName);
   }
}