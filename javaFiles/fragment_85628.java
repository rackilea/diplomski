//...
} catch (WebServiceException e){
    String name = e.getClass().getSimpleName();
    if(name.equals("ClientTransportException")){
        //do what you want
    } else if (name.equals("DeserializationException")){
        //do something else
    }

}