public enum JAXBContextSingleton {

INSTANCE("your.class.xsd");
private JAXBContext context;

JAXBContextSingleton(String classToCreate) {
    try {
        this.context = JAXBContext.newInstance(classToCreate);
    } catch (JAXBException ex) {
        throw new IllegalStateException("Unbale to create JAXBContextSingleton");
    }
}

public JAXBContext getContext(){
    return context;
}

}