public class Poj implements Serializable{

    @JsonProperty("ADDRESS")
    private String address;
    @JsonProperty("DESCP")
    private String descp;
    @JsonProperty("DEVICE size")
    private Double deviceSize;
    @JsonProperty("DIRECTORY NUMBER 1")
    private Long directoryNumberOne;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public Double getDeviceSize() {
        return deviceSize;
    }

    public void setDeviceSize(Double deviceSize) {
        this.deviceSize = deviceSize;
    }

    public Long getDirectoryNumberOne() {
        return directoryNumberOne;
    }

    public void setDirectoryNumberOne(Long directoryNumberOne) {
        this.directoryNumberOne = directoryNumberOne;
    }
}



public class JsonToPojo {
    public static List<Poj>  conver(String data) throws IOException {
        ObjectMapper ob = new ObjectMapper();
       return  ob.readValue(data,new TypeReference<List<Poj>>() { });
    }

    @Test
    public void testConver() throws IOException {
        String data = "[ { \"ADDRESS\" : \"ewrer23214324\", \"DESCP\" : \"LO-3434\", \"DEVICE size\" : \"1.01091E+11\", \"DIRECTORY NUMBER 1\" : \"+34343\" } ]";

        List<Poj> list = JsonToPojo.conver(data);
        for (Poj p:list){
            System.out.println(p.getAddress()+":"+p.getDescp()+":"+p.getDeviceSize()+":"+p.getDirectoryNumberOne());
        }
    }
}