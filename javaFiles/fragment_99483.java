File file = ...;

public void convToXML(SampleClass sample, File file){
    try{
        JAXBContext jaxbContext = JAXBContext.newInstance(SampleClass.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(trans, new FileOutputStream(file, true));
        jaxbMarshaller.marshal(trans, System.out);

    }catch(JAXBException e){
        e.printStackTrace();
    }
}

file.delete();
while(condition){
    SampleClass sample = new SampleClass();
    sample.setName("Sample");
    sample.setId("432");
    convToXML(sample, file)
}