@MessagingGateway(defaultRequestChannel = "inChan", defaultReplyChannel = "outChan" )    
public interface CalAmpSIRouteAndProcessService {

    @Gateway(requestChannel = "inChan", replyChannel = "outChan" )
    Future<CalAmpSIWrapper> processMessage(Object message, @Header("headerKey") String neededHeader);
}