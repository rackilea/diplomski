public class MarshalHandler {

    private JAXBContext jc;
    private Unmarshaller unmarshaller;
    private Marshaller marshaler;

    public MarshalHandler(){
        jc = JAXBContext.newInstance(Tests.class);
        unmarshaller = jc.createUnmarshaller();
        marshaler = jc.createMarshaller();
    }


    public Test unmarshall(File f){
        return (Tests) unmarshaller.unmarshal(f);
    }

    public void marshal(Tests t, String fileLoc){
        OutputStream os = new FileOutputStream(fileLoc);
        marshaler.marshal(t, os);
        os.flush();
        os.close();
    }
}