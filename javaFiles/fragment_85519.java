@RequestMapping("/oauth2callback")
public String callback(HttpServletRequest request) {

    /*
     * Terrible hack for testing Twitter Oauth on 'localhost'
     */
    if (request.getServerName().contains("127.0.0.1")){
        int port = request.getServerPort();
        String query = (request.getQueryString() == null) ? "" : "?" +request.getQueryString();
        String url = "redirect:https://localhost:" + port +"/oauth2callback" + query;
        return url;
    }

    return "account/oauth2callback";
}