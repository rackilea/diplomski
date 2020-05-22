Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
String x = params.get("x");
String y = params.get("y");
String x2 = params.get("x2");
String y2 = params.get("y2");
String w = params.get("w");
String h = params.get("h");