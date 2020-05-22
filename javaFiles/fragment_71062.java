private static String urlFor(HttpServletRequest request, String code, String email, boolean forgot) {
    try {
        URI htmlLink = new URI(createHtmlLink());
        String query = htmlLink.getQuery();
        String fragment = htmlLink.getFragment();
        fragment += "code="+code+"&email="+email;
        if(forgot){
            fragment += "&forgot=true";
        }
        URI url = new URI(request.getScheme(), null, request.getServerName(), request.getServerPort(), htmlLink.getPath(),
                    query, fragment);
        String s = url.toString();
        return s;
    } catch (URISyntaxException e) {
        throw new RuntimeException(e);
    }
}