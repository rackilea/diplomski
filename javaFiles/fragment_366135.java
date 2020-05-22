....
        public class MyJMXHTTPSessionListener implements HttpSessionListener {
        ....
          private SessionsImpl sesssionsImpl;
          private Map<String, HttpSessionMXBeanImpl> httpSessionMXBeans

          @Override
          public void sessionCreated(HttpSessionEvent se) {
            //requires synchronized block here with this i.e.
            synchronized (this) {
            /*check if a jmx bean instance of the 1st interface exists otherwise create one*/
    if(sessionsImpl==null){
    sesssionsImpl= new SesssionsImpl();
/* take care here to create a nice and unique path per instance 
of the application in order to be nicely presented on the JMX tree of the JMX clients  */
                        String id = ("services.jmx.beans:type=Sessions,"+ "realm=" + se.getSession().getServletContext().getContextPath());
                        sessionManagerMXBean.setId(id);
                        ObjectName objectName = new ObjectName(id);
                        if (ManagementFactory.getPlatformMBeanServer().isRegistered(objectName)) {
                            ManagementFactory.getPlatformMBeanServer().
                                    unregisterMBean(objectName);
                        }
                        ManagementFactory.getPlatformMBeanServer().
                                registerMBean(sesssionsImpl,
                                objectName);
    }

    sesssionsImpl.inrementSessions();

    /*

               create a jmx bean instance of the 2nd interface

 and register it to the jmx service as already shown using the unique session id

 and a nice path indicating the 2nd interface jmx beans.
    */

          }

          @Override
          public void sessionDestroyed(HttpSessionEvent se) {
            //requires synchronized block here with this i.e.
            synchronized (this) {
            /*unregister the jmx bean instance of the 2nd interface, 

remove it from the list 

and call decrementSessions() on the jmx bean instance corresponding to this app*/
            }
          }
        }