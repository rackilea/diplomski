<%! int TOTAL_NUMBER_OF_ROW = 10; %>
<form action="TimeSheet" method="post">
            <fieldset style="width: 90%">  
                <legend>Timesheet</legend>   
                <h2>Time Sheet application</h2>
    <table border=1>
    <tr><th>Employee ID</th><th>Date</th><th>Time In</th><th>Time Out</th><th>Lunch</th><th>After Lunch Time in</th><th>After Lunch Time out</th><th>Task Description</th><th>Total Hours</th><th>Overtime</th> </tr>

    <%for(int j =0;j<TOTAL_NUMBER_OF_ROW;j++){ %>

        <tr> 
    <td><input type="text" name="empid" required="required" /></td>   
    <td><input type="date" id="date" name="date"/></td>
    <td><input type="time" class="start" name="logintime"/></td>
    <td><input type="time" class="end"name="logouttime" /></td>
    <td><input type="time" class="lunch" name="lunch" /></td>
    <td><input type="time" class="startafterlunch" name="afterlunchlogin"/></td>
    <td><input type="time" class="endafterlunch" name="afterlunchlogout"/></td>
    <td><input type="textarea" name="task" required="required" /></td>
    <td><input class="totalTime" readonly="readonly" /></td>
    <td><input class="overTime" readonly="readonly" /></td>
    </tr>

    <%}%>


    </table>
            </fieldset>      
             <input type="submit" value="Submit">
        </form>