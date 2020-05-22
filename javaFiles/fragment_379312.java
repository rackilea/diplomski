public class ClientClass{

    private ARNStorage endPoint;

    public void storeEndpointArn(String endpointArn) {    
        endPoint = new ARNStorage();
        endPoint.setArnStorage(endpointArn);
        System.out.println("Storing endpoint: " + endpointArn);
    }

    public String retrieveEndpointArn() {
        String endPointArn = endPoint.getArnStorage();
        System.out.println("Retrieved endpoint: " + endPointArn);
        return endPointArn;
    }
}