@FeignClient(name = "downloadAPI", url = "${service.ip}")
public interface DownloadApiProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/downloadFile")
    public byte[] downloadFile(HttpServletResponse response, @RequestParam(value = "messageId", required = false) String messageId);

     :
     :
}