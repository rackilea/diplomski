------------------------------HTML--------------------------

<select name="RISKFACTOR" style="width: 300px;" onchange="fnReload('F');">
    <option value="" selected>Select Tariff Type</option>
    <%for(Iterator i = alRiskFactor.iterator(); i.hasNext();) {
        ArrayList alInner = (ArrayList) i.next();
        String code       = (String) alInner.get(0);
        String descp      = (String) alInner.get(1);

    %>
    <option value="<%=code%>" <%= code.equals(RISKFACTOR)?"selected":"" %>><%=descp%></option>
    <%}%>
    <%for(Iterator e = exRiskFactor.iterator(); i.hasNext();) {
        alInner  = (ArrayList) e.next();
        code     = (String) alInner.get(0);
        descp        = (String) alInner.get(1);

    %>
    <option value="<%=code%>" <%= code.equals(RISKFACTOR)?"selected":"" %>><%=descp%></option>
    <%}%>
</select>