<% String hidden = request.getParameter("inputName"); 
    int j=Integer.parseInt(hidden);
    %>

    <%    String s[] = new String[j];
    int k=0;
    for (int i=0; i<j; i++){
        k++;
    s[i] = request.getParameter(Integer.toString(k)); 
    out.println(s[i]);
    }%>