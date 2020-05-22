@Service
class MySocket {

    // ...

    public income(InputStream stream) {

        // ...

        for (BaseService service : services) {
            if (service.canHandle(action)) {

                // Here, getContext() returns a subclass of ServiceContext 
                // that holds the service specific objects 
                // (in this example dataVO)
                ServiceContext context = service.getContext();

                service.invoke(context);

            }
        }
    }
}