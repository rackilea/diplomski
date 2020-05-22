@MessageMapping("/user/sockettest" )
@SendTo("/topic/sockettestresult")
public String sockAdd(ListId[] listIds, Principal principal) {
    //do whatever you want 
    return stringRet;
}