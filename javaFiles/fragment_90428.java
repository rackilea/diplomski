public static void main(String[] args) throws DatatypeConfigurationException {
    GregorianCalendar cal = new GregorianCalendar();
    XMLGregorianCalendar xmlBirthDt = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), 
                                cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);

    XStream x = new XStream();
    x.alias("date", com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl.class);
    x.registerConverter(new Converter() {
        @Override
        public boolean canConvert(Class arg0) {
            return arg0.equals(com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl.class);
        }

        @Override
        public Object unmarshal(HierarchicalStreamReader arg0, UnmarshallingContext arg1) {
            return null;
        }

        @Override
        public void marshal(Object arg0, HierarchicalStreamWriter arg1, MarshallingContext arg2) {
            XMLGregorianCalendar x = (XMLGregorianCalendar) arg0;
            arg1.setValue(x.toString());
        }
    });

    String g = x.toXML(xmlBirthDt);

    System.out.println(g);
}