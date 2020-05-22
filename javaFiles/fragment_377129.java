public void jspInit() {
    try {
        InitialContext ic = new InitialContext();
        Object objRef = ic.lookup("java:comp/env/ejb/Converter");
        ConverterHome home = (ConverterHome) PortableRemoteObject.narrow(objRef, ConverterHome.class);
        converter = home.create();

    }catch(NamingException ne){
    }catch (RemoteException ex) {
    }catch(CreateException ce){
    }
}