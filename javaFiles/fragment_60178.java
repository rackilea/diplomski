@Autowired
private int serverPort; 

/*
 * ... 
 */

private String constructRequestURL(HttpServletRequest httpRequest) {

    StringBuilder url = new StringBuilder(httpRequest.getScheme())
            .append("://").append(findHostnameFromServer()).append(":").append(serverPort)
            .append(httpRequest.getContextPath()).append(httpRequest.getServletPath());

    if(httpRequest.getPathInfo() != null) {
        url.append(httpRequest.getPathInfo());
    }
    if(httpRequest.getQueryString() != null) {
        url.append("?").append(httpRequest.getQueryString());
    }
    return url.toString();
}

private String findHostnameFromServer(){

    String hostname = null;
    LOGGER.info("Attempting to Find Hostname from Server...");
    try {
        Process process = Runtime.getRuntime().exec(new String[]{"hostname"});
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            hostname = reader.readLine();
        }

    } catch (IOException e) {
        LOGGER.error(CommonUtil.ERROR, e);
    }
    LOGGER.info("Found Hostname: {}", hostname);
    return hostname;
}