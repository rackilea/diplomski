package com.somepackage;

public class DirectionConverter implements HttpMessageConverter<Sort.Direction> {

    public boolean canRead(Class<?> aClass, MediaType mediaType) {
        return aClass== Sort.Direction.class;
    }

    public boolean canWrite(Class<?> aClass, MediaType mediaType) {
        return false;
    }

    public List<MediaType> getSupportedMediaTypes() {
        return new LinkedList<MediaType>();
    }

    public Sort.Direction read(Class<? extends Sort.Direction> aClass,
                                 HttpInputMessage httpInputMessage) 
                                 throws IOException, HttpMessageNotReadableException {   

        String string = IOUtils.toString(httpInputMessage.getBody(), "UTF-8");
        //here do any convertions and return result 
    }

    public void write(Sort.Direction value, MediaType mediaType, 
                      HttpOutputMessage httpOutputMessage) 
                      throws IOException, HttpMessageNotWritableException {

    }

}