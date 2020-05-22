private final static <T> String serialize(T obj, Map<Class<?>, 
        XmlAdapter<?,?>> classToAdapterMap) throws JAXBException 
{
    Object adaptedObj = null;

    for (Class<?> clazz : classToAdapterMap.keySet()) {
        if (clazz.isInstance(obj)) {
            try {
                XmlAdapter<?, ? super T> adapter = (XmlAdapter<?, ? super T>) classToAdapterMap.get(clazz);
                adaptedObj = adapter.marshal(obj);
                break;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // serialize
}