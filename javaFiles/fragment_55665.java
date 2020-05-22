@RequestMapping(value = {"sms"},method = RequestMethod.POST)
public string rplyMessage(
    HttpServletRequest request,
    HttpServletResponse response,
    @RequestParam("Body") String message,
    @RequestParam("From") String from
) throws IOException {
    storeMessage(from, message);

    // respond to the request
}