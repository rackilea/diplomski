public class CxfRestSingleton {

    public static GenService obj;

    public static GenService getInstance() {

        if (obj == null) {
            obj = JAXRSClientFactory.create("http://localhost:8080/RestfulSample/Restful", GenService.class);
        }
        return obj;
    }

}