<%@page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  

<title>Timesheet Page</title>  
</head>  
<body>  

<form action="TimeSheetServlet" method="post">
    <fieldset style="width: 90%">  
        <legend>Timesheet</legend>   
        <table> 
            <thead><tr><th>Employee ID</th><th>Date</th><th>Time In</th><th>Time Out</th><th>Lunch</th><th>After Lunch Time in</th><th>After Lunch Time out</th><th>Task Description</th><th>Total Hours</th><th>Overtime</th> </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="text" name="empid1" required="required" /></td>   
                    <td><input type="date" id="date" name="logindate1" required="required" /></td>  
                    <td><input type="time" class="start" name="logintime1" required="required" /></td>  
                    <td><input type="time" class="end" name="logouttime1" required="required" /></td> 
                    <td><input type="time" class="lunch" name="lunch1" required="required" /></td>  
                    <td><input type="time" class="startafterlunch"  name="afterlunchlogin1" required="required" /></td>  
                    <td><input type="time" class="endafterlunch" name="afterlunchlogout1" required="required" /></td> 
                    <td><input type="textarea" name="1" required="required" /></td>
                    <td><input type="time" class="totalTime" name="total1" /></td>
                    <td><input type="time" class="overTime" name="overtime1" required="required" /></td>
                </tr>  
                <tr>
                    <td><input type="text" name="empid2" required="required" /></td>   
                    <td><input type="date" id="date" name="logindate2" required="required" /></td>  
                    <td><input type="time" class="start" name="logintime2" required="required" /></td>  
                    <td><input type="time" class="end" name="logouttime2" required="required" /></td> 
                    <td><input type="time" class="lunch" name="lunch2" required="required" /></td>  
                    <td><input type="time" class="startafterlunch"  name="afterlunchlogin2" required="required" /></td>  
                    <td><input type="time" class="endafterlunch" name="afterlunchlogout2" required="required" /></td> 
                    <td><input type="textarea" name="task2" required="required" /></td>
                    <td><input type="time" class="totalTime" name="total2" /></td>
                    <td><input type="time" class="overTime" name="overtime2" required="required" /></td>
                </tr>  
                <tr>
                    <td><input type="text" name="empid3" required="required" /></td>   
                    <td><input type="date" id="date" name="logindate3" required="required" /></td>  
                    <td><input type="time" class="start" name="logintime3" required="required" /></td>  
                    <td><input type="time" class="end" name="logouttime3" required="required" /></td> 
                    <td><input type="time" class="lunch" name="lunch3" required="required" /></td>  
                    <td><input type="time" class="startafterlunch"  name="afterlunchlogin3" required="required" /></td>  
                    <td><input type="time" class="endafterlunch" name="afterlunchlogout3" required="required" /></td> 
                    <td><input type="textarea" name="task" required="required" /></td>
                    <td><input type="time" class="totalTime" name="total3" /></td>
                    <td><input type="time" class="overTime" name="overtime3" required="required" /></td>
                </tr>  
                <tr>
                    <td><input type="text" name="empid4" required="required" /></td>   
                    <td><input type="date" id="date" name="logindate4" required="required" /></td>  
                    <td><input type="time" class="start" name="logintime4" required="required" /></td>  
                    <td><input type="time" class="end" name="logouttime4" required="required" /></td> 
                    <td><input type="time" class="lunch" name="lunch4" required="required" /></td>  
                    <td><input type="time" class="startafterlunch"  name="afterlunchlogin4" required="required" /></td>  
                    <td><input type="time" class="endafterlunch" name="afterlunchlogout4" required="required" /></td> 
                    <td><input type="textarea" name="task" required="required" /></td>
                    <td><input type="time" class="totalTime" name="total4" /></td>
                    <td><input type="time" class="overTime" name="overtime4" required="required" /></td>
                </tr>  
                <tr>
                    <td><input type="text" name="empid5" required="required" /></td>   
                    <td><input type="date" id="date" name="logindate5" required="required" /></td>  
                    <td><input type="time" class="start" name="logintime5" required="required" /></td>  
                    <td><input type="time" class="end" name="logouttime5" required="required" /></td> 
                    <td><input type="time" class="lunch" name="lunch5" required="required" /></td>  
                    <td><input type="time" class="startafterlunch"  name="afterlunchlogin5" required="required" /></td>  
                    <td><input type="time" class="endafterlunch" name="afterlunchlogout5" required="required" /></td> 
                    <td><input type="textarea" name="task5" required="required" /></td>
                    <td><input type="time" class="totalTime" name="total5" /></td>
                    <td><input type="time" class="overTime" name="overtime5" required="required" /></td>
                </tr>  
            </tbody>
        </table>  
    </fieldset>      
     <input type="submit" value="Submit">
</form>
<a href="logout.jsp">Logout</a>
</body>  
</html>