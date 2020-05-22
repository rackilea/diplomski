import org.osgi.framework.*;

    import javax.xml.parsers.SAXParserFactory;

    import net.wimpi.telnetd.util.Latch;

    /**
     * Implements a mediator pattern class for services from the OSGi container.
     * <p/>
     *
     * @author Dieter Wimberger (wimpi)
     * @version @version@ (@date@)
     */
    class ServiceMediator {

      private BundleContext m_BundleContext;

      private SAXParserFactory m_SAXParserFactory;
      private Latch m_SAXParserFactoryLatch;

      public SAXParserFactory getSAXParserFactory(long wait) {
        try {
          if (wait < 0) {
            m_SAXParserFactoryLatch.acquire();
          } else if (wait > 0) {
            m_SAXParserFactoryLatch.attempt(wait);
          }
        } catch (InterruptedException e) {
          e.printStackTrace(System.err);
        }

        return m_SAXParserFactory;
      }//getSAXParserFactory

      public boolean activate(BundleContext bc) {
        //get the context
        m_BundleContext = bc;

        m_SAXParserFactoryLatch = createWaitLatch();

        //prepareDefinitions listener
        ServiceListener serviceListener = new ServiceListenerImpl();

        //prepareDefinitions the filter
        String filter = "(objectclass=" + SAXParserFactory.class.getName() + ")";

        try {
          //add the listener to the bundle context.
          bc.addServiceListener(serviceListener, filter);

          //ensure that already registered Service instances are registered with
          //the manager
          ServiceReference[] srl = bc.getServiceReferences(null, filter);
          for (int i = 0; srl != null && i < srl.length; i++) {
            serviceListener.serviceChanged(new ServiceEvent(ServiceEvent.REGISTERED, srl[i]));
          }
        } catch (InvalidSyntaxException ex) {
          ex.printStackTrace(System.err);
          return false;
        }
        return true;
      }//activate

      public void deactivate() {
        m_SAXParserFactory = null;

        m_SAXParserFactoryLatch = null;

        m_BundleContext = null;
      }//deactivate

      private Latch createWaitLatch() {
        return new Latch();
      }//createWaitLatch

      private class ServiceListenerImpl
          implements ServiceListener {

        public void serviceChanged(ServiceEvent ev) {
          ServiceReference sr = ev.getServiceReference();
          Object o = null;
          switch (ev.getType()) {
            case ServiceEvent.REGISTERED:
              o = m_BundleContext.getService(sr);
              if (o == null) {
                return;
              } else if (o instanceof SAXParserFactory) {
                m_SAXParserFactory = (SAXParserFactory) o;
                m_SAXParserFactory.setValidating(false);
                m_SAXParserFactory.setNamespaceAware(true);
                m_SAXParserFactoryLatch.release();
              } else {
                m_BundleContext.ungetService(sr);
              }
              break;
            case ServiceEvent.UNREGISTERING:
              o = m_BundleContext.getService(sr);
              if (o == null) {
                return;
              }  else if (o instanceof SAXParserFactory) {
                m_SAXParserFactory = null;
                m_SAXParserFactoryLatch = createWaitLatch();
              } else {
                m_BundleContext.ungetService(sr);
              }
              break;
          }
        }
      }//inner class ServiceListenerImpl

      public static long WAIT_UNLIMITED = -1;
      public static long NO_WAIT = 0;

    }//class ServiceMediator