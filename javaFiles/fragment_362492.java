public class JAXBToJsonConverter {
     public static void main(String[] args) {
        try {  
            //save the company details content to a .xml file
            // and refer the path below
            File file = new File("C:\\myproject\\company.xml");  

            //create the jaxb context and unmarshall
            JAXBContext jaxbContext = JAXBContext.newInstance(Company.class);  

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();  
            Company company= (Company) jaxbUnmarshaller.unmarshal(file);  

            //create the JSON object
            JSONObject json = new JSONObject(company);
            System.out.println(json);
          } catch (JAXBException e) {  
            e.printStackTrace();  
          }  
    }
  }