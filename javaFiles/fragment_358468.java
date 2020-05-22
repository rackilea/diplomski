<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%session.setAttribute("hi","hi");

Map map = new HashMap();
map.put( new Integer( 2 ), "two" );
map.put( new Integer( 4 ), "four" );
//System.out.println( map );
// sending param to two.jsp
session.setAttribute("value",map);%>