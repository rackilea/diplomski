Enumeration allParameterNames = request.getParameterNames();
while(allParameterNames.hasMoreElements())
{
    Object object = allParameterNames.nextElement();
    String param =  (String)object;
    String value =  request.getParameter(param);
    pw.println("Parameter Name is '"+param+"' and Parameter Value is '"+value+"'");
}