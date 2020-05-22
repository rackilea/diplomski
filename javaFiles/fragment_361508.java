<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
        <head>
                <link rel="stylesheet" type="text/css" href="css/myStyle.css">
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="jquery.js"></script>
                <title>Show Tail Logs</title>
                <script>
                        var binDone = false;
                        var lastUpdate = "Starting logs";
                        function tail2() {
                                if (!binDone) {
                                        $.post("/<<Context>>/TailLogServlet",
                                          {
                                                logUID:"<%= request.getParameter("logUID")%>",
                                                logPwd:"<%= request.getParameter("logPwd")%>",
                                                host:"<%= request.getParameter("host")%>",
                                                logFileName:"<%= request.getParameter("logFileName")%>"
                                          },
                                          function(data,status){
                                                $("#thePlace").append(data);
                                                if (data.indexOf(lastUpdate)>-1) {
                                                        binDone = true;
                                                }
                                          });
                                }
                        }
                </script>
        </head>
    <body onLoad='tail2(); setInterval("tail2()", 2000)'>
        <div id="wrapper" class="radius">
                <div id="imageContainer">
                        <img alt="my Image" class="myLogo" src="myLogo.jpg" />
                        <h1>Show Tail Logs</h1>
                </div>
                <div id="navContainer" style="color:white">
                        Logs Update automatically. Please don't press refresh button...
                </div>
                        <div>
                                <div id="thePlace"></div>
                        </div>
                </body>
        </div>
</html>