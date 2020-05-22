<select name="mainHeading" id="mainHeading">

<%if(mainHeading != null && mainHeading.equals("Future Plans")){%>
    <option value="Future Plans">Future Plans</option>
    <option value="Operations">Operations</option>
<%}%>

<%if(mainHeading != null && mainHeading.equals("Operations")){%>
    <option value="Operations">Operations</option>
    <option value="Future Plans">Future Plans</option>
<%}%>

<%if(mainHeading == null){%>
    <option value="Operations">Operations</option>
    <option value="Future Plans">Future Plans</option>
<%}%>

  </select>