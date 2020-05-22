<%
    // getting jsp (servlet) client ip
    String remoteIp = request.getRemoteAddr();

    // getting local ip
    InetAddress address = InetAddress.getLocalHost();
    String localhostIp = address.getHostAddress();

    // checking and forwarding
    if(localhostIp.equals(remoteIp)){
%>
     <jsp:forward page="localhost.html"/>
<%}else{%>
    <jsp:forward page="remote.html"/>
<%}%>