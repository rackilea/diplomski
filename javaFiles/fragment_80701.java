@Get(produces = MediaType.TEXT_PLAIN)
public String index() {
    ReactorConnectorManager<RequestInfoDTO, String> reactorConnectorRestManagerExecutor =
            Application.springContext.getBean(ReactorConnectorManager<RequestInfoDTO, String>.class);
    if(reactorConnectorRestManagerExecutor  == null){
        return "boooo";
    }
    return "Hello World";
}