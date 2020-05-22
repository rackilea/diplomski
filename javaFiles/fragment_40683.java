DatatypeFactory df; 
try { 
    df = DatatypeFactory.newInstance(); 
    return df.newXMLGregorianCalendar(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")); 
} catch (DatatypeConfigurationException e) { 
    // throw new SomeRuntimeException(e); 
}