package forum9881188;

import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(FindRequestDTO.class);

        FindRequestDTO fr = new FindRequestDTO();
        fr.setAPIRequest(new ApiRequestDTO());

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(fr, System.out);
    }

}