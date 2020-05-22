public interface WebScript
{
  /**
 * Execute the Service
 * 
 * @param req   WebScriptRequest representing the request to this service
 * @param res   WebScriptResponse encapsulating the result of this service
 * 
 * @throws IOException
 */
public void execute(WebScriptRequest req, WebScriptResponse res)
    throws IOException;
}