void unmarshal() throws Exception {
    JAXBContext jc = JAXBContext.newInstance( PACKAGE );
    Unmarshaller m = jc.createUnmarshaller();
    JAXBElement<?> obj = (JAXBElement<?>)m.unmarshal( new File( XMLIN ) );
    DocType dt = (DocType)obj.getValue();
    MappingType mt = dt.getData();
    for( Object elobj: mt.getAny() ){
        System.out.println( "object: " + elobj.getClass() );
    }
    System.out.println( "done" );
}