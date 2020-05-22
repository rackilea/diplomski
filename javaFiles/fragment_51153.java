<s:iterator value="variables">
    <s:set var="mySign" value="%{sign}" name="mySign" scope="request"></s:set>
    <jsp:useBean id="mySign" class="java.lang.String" scope="request" ></jsp:useBean>           
    <input type="text" 
        id="<s:property value="sign"/>"
        name="<s:property value="sign"/>"  
        value="<%=request.getAttribute(mySign)%>">
</s:iterator>