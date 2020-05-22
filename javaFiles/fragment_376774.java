<% Cookie cookies[] = request.getCookies();
   String myCookie = null;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equalsIgnoreCase("MyCookie")) {
                myCookie = cookies[i].getValue();
                out.println("Value is:" + cookies[i].getValue());
            }
        }
    %>
    <form id="everything" onsubmit="myfunc('<%=myCookie%>')">