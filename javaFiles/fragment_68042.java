//textView.jsp
<%@page import="model.TextBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
        </head>
        <body>
            <div class="row">
                <%
                TextBean txt=new TextBean();
                txt=(TextBean)request.getAttribute("txt");
                String text="";
                if(txt!=null && txt.getText()!=null){
                    text=txt.getText();
                }
                %>
                    <div class="col-md-10">
                        <textarea name="bottxt" id="disabledTextInput" border="2" class="form-control col-xs-6" rows="8" cols="60"><%=text%></textarea><br>
                        <form class="form-horizontal" action="ChatController" method="post">
                        <input class="form-control" type="text" name="usertxt" placeholder="your text here">
                        <button type="submit"  class="btn btn-success active"> Send </button>
                       </form>
                    </div>
            </div>
        </body>
    </html>