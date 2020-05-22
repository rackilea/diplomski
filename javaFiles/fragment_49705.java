public class SOAPServlet extends CXFNonSpringServlet {

    private static final long serialVersionUID = 1L;
    private Map<String, Object> endpoints;


    public SOAPServlet(){
        endpoints = new HashMap<String, Object>();
    }

    @Override
    public void loadBus(ServletConfig servletConfig) {
        super.loadBus(servletConfig);        

        // You could add the endpoint publish codes here
        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Set s = endpoints.entrySet();
        Iterator p = s.iterator();
        while(p.hasNext()){
            Map.Entry m = (Map.Entry)p.next();
            String address = (String)m.getKey();
            Object impl = (Object)m.getValue();
            System.out.println("Publishing " + address);
            Endpoint.publish(address, impl);
        }
    }
    public void publish(String address, Object impl){
        endpoints.put(address, impl);
    }
}