<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <div>Number of Messages</div>
        <div id="out">

        </div>
        <div>Messages per Second:</div>

        <div id="mean">

        </div>

    </body>

    <script type="text/javascript">

        var startTime = new Date().getTime();
        var counter = 0;

        var eventSource = new EventSource("EventServlet");

        eventSource.addEventListener('simpleEvent', function(event){
            counter++;
            document.getElementById("out").innerHTML=counter;

            var seconds = (new Date().getTime()-startTime)/1000;
            document.getElementById("mean").innerHTML=counter/seconds;
        },false);

    </script>
</html>