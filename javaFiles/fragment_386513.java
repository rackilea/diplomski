<%! int clicks = 0; %>

<%
    String param = request.getParameter("integer");

    try
    {
       int i = Integer.parseInt(param);

       clicks ++;
    } 
    catch (NumberFormatException e)
    {
    }
%>
<p>Number of clicks untill now: <%= clicks %> </p>

<form action="">
    <input type="text" name="integer" value="1"/>
    <input type="submit" value="submit" />
</form>