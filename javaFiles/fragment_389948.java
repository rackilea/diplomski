public class APIService {

private static Map<String, Service> services = new HashMap<>();

private static final Map<String, String> availableServices = new HashMap() {{
    put("fedex", "com.finity.shipping.api.fedexapi.FedexRequest");
    put("endicia", "com.finity.shipping.api.endiciaapi.EndiciaRequest");
}};

public static Service getService(String type) {
      return services.get(type);
}

static {
    for(Map.Entry<String, String> serv : availableServices.entrySet()) {
        try {
            Class<?> cls = Class.forName(serv.getValue());
            services.put(serv.getKey(), cls.newInstance());
        } catch(Exception e) {
            services.put(serv.getKey(), new Class[1]);
        }
    }
}

}