<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%! GregorianCalendar newYear = new GregorianCalendar(2013, 0, 1);

    /*
     * 0 : January
     * 1 : 1st January
     * 2013 : year
     */%>
        <div>
        Time : 
        <%= (newYear.getTimeInMillis() - new GregorianCalendar().getTimeInMillis()) / 1000%>
        </div>