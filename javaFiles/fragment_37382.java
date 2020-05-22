// parameter passed from top frame
final String parameterName = "urlsel";
// read the value
String url = request.getParameter(parameterName);

// business logic, e.g. reading the stats and populating 
// the scope values to be provided to the view

// provide url value as a parameter for refresh request
response.setHeader("Refresh","10;url="+request.getContextPath+"/SiteAvailabilityServlet?urlSel=" + url);