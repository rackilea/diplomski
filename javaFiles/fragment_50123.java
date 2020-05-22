<%
    ActionContext context = ActionContext.getContext();

    //this will access actionClass.getFoo() just like the tag
    //<s:property value="%{foo}"/> does but outputs to HTML
    Object fooObj = context.getValueStack().findValue("foo");
    String fooStr = (String)fooObj;

    //so that we can print it to the console
    //because the tag can only output to HTML 
    //and printing to the console is the objective of the question
    System.out.println("foo = " + fooStr);
%>