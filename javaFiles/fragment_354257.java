%@ page language="java" contentType="text/html; charset=utf-8" 
                         pageEncoding="utf-8" %>
<%@ page import="javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>
<%@ page import="javax.activation.*"%>
<%@ page import="java.util.*,java.io.*"%>
<%@ page language="java" %>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>   

<%
 sendSMS(arg1, arg2, arg3, ar4, response)
%>

<%!
public void sendSMS(String nickName, 
                    String setAname, 
                    String currAname,                                                         
                    String toPhone,
                    ServletResponse response){
    String acctInfo="xxx";
    String acctPwd="xxx";
    String contents="Message from Miss U:( \n Please be reminded that your friend:"+nickName+" is OUT of your setting area: "+setAname+". The current area is "+currAname+".";

    String smsURL="http://api.accessyou.com/sms/sendsms-utf8.php?msg="+contents+"&phone="+toPhone+"&pwd="+acctPwd+"&accountno="+acctInfo;
    response.sendRedirect(smsURL);
}
%>