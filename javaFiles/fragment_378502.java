class Elem{
    String name;
    Object value;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Object getValue() {
        return value;
    }
    public void setValue(Object value) {
        this.value = value;
    }
}

List<Elem> parseComplexSoapObject(SoapObject soapObject) {
    List<Elem> tmp=new ArrayList<Elem>();
    PropertyInfo info=new PropertyInfo();

    for (int i=0; i<soapObject.getPropertyCount(); i++) {
        Object currentPropertyObject = soapObject.getProperty(i);

        Elem newElem = new Elem();
        if(currentPropertyObject instanceof SoapObject){
            SoapObject currentPropertySoapObject = (SoapObject)currentPropertyObject;
            info.clear();
            soapObject.getPropertyInfo(i, info);
            newElem.setName(info.name);
            newElem.setValue(parseComplexSoapObject(currentPropertySoapObject));
        }else{
            //assume primitive
            SoapPrimitive currentPropertySoapPrimitive = (SoapPrimitive)currentPropertyObject;
            info.clear();
            soapObject.getPropertyInfo(i, info);
            newElem.setName(info.name);
            newElem.setValue(currentPropertySoapPrimitive.getValue().toString());
        }
        tmp.add(newElem);
    }

    return tmp;
}