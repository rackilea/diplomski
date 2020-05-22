@SuppressWarnings("unchecked")
    public <T> T getOthersParsedAs(Class<T> clazz) throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        T res = (T) unmarshaller.unmarshal((Node)others[0]);    
        if (res instanceof JAXBElement){
            res = (T)JAXBIntrospector.getValue(res); 
        }
        return res;
    }