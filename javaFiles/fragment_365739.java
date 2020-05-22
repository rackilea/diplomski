String[] parameters = URLDecoder.decode(request.getQueryString(), "UTF-8").split("&");
if (parameters.length > 0) {
    String firstPair = parameters[0];
    String[] nameValue = firstPair.split("=");
    System.out.println("Name:" + nameValue[0] + " value:" + nameValue[1]);
}