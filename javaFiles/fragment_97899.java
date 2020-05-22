/**
* Signs the request and sends it. Returns the response.
*
* @param request
* @return response
*/
public static Response signAndSendToVimeo(OAuthRequest request, String description, boolean printBody) throws org.scribe.exceptions.OAuthException {
  System.out.println(newline + newline
          + "Signing " + description + " request:"
          + ((printBody && !request.getBodyContents().isEmpty()) ? newline + "\tBody Contents:" + request.getBodyContents() : "")
          + ((!request.getHeaders().isEmpty()) ? newline + "\tHeaders: " + request.getHeaders() : ""));
  service.signRequest(accessToken, request);
  printRequest(request, description);
  Response response = request.send();
  printResponse(response, description, printBody);
  return response;
}