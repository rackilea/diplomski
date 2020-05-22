<%-- 
    Document   : nyblast
    Created on : Dec 26, 2012, 10:44:27 AM
    Author     : non-admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body bgcolor="#73AF59">

<script type="text/javascript" src="/js/jquery.min.js">

        </script>
<script type="text/javascript">
            var auto_refresh = setInterval(
            function ()
            {
                $('#load_tweets').load('reload-window.jsp').fadeIn("slow");
            }, 5000); // refresh every 10000 milliseconds

          </script>



<table width="100%">
    <tr>
        <td width="40%"></td>
        <td><img src="images/animations/pyear.gif" /></td>
    </tr>
    <tr>
        <td width="40%">
        <center><font face="Chiller" size="+6"> <br />
        Countdown </font></center>
        </td>
        <td>
        <center><font face="Chiller" size="+6"> <br />

        <div id="load_tweets"></div>
        </font></center>
        </td>
    </tr>
    <tr>
        <td colspan="2" style="height: 400px" valign="bottom"><img
            src="images/animations/3D_balloons.gif" /> <em>This poor design
        and animations compiled by Suhail Gupta.</em> <audio
            style="visibility: hidden"> </audio></td>
    </tr>
    <!-- !-->
</table>

</body>

</html>