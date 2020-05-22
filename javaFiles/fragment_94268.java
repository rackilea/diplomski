public class SuperGenericClient<E> extends GenericWsClient {
    public void send(List<E> entityList, String service) {
        WebResource ws = super.getWebResource(service);
        try {
            String response = ws.accept(MediaType.TEXT_HTML).type(MediaType.APPLICATION_XML).put(String.class, new GenericEntity<E>(entityList) {
            });
        }            
    }
}

public class GenericEntity<E> {
    public GenericEntity(List<E> list){

    }
}