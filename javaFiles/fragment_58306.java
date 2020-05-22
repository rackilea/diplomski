<%@ page import="java.util.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%
    ArrayList<String> listA = new ArrayList<String>();
    listA.add("a1");
    listA.add("a2");
    listA.add("a3");
    listA.add("a4");
    listA.add("a5");
    pageContext.setAttribute("listA", listA);
    ArrayList<String> listB = new ArrayList<String>();
    listB.add("b1");
    listB.add("b2");
    listB.add("b3");
    listB.add("b4");
    listB.add("b5");
    pageContext.setAttribute("listB", listB);
    ArrayList<String> listC = new ArrayList<String>();
    listC.add("c1");
    listC.add("c2");
    listC.add("c3");
    listC.add("c4");
    listC.add("c5");
    pageContext.setAttribute("listC", listC);
    ArrayList<String> listD = new ArrayList<String>();
    listD.add("d1");
    listD.add("d2");
    listD.add("d3");
    listD.add("d4");
    listD.add("d5");
    pageContext.setAttribute("listD", listD);
%>
    <c:set value="${fn:length(listA)}" var="listSize" />
<html>
    <body>
        <table>
            <c:forEach begin="0" end="${listSize - 1}" var="current">
                <tr>                
                    <td>${listA[current]}</td>   
                    <td>${listB[current]}</td> 
                    <td>${listC[current]}</td> 
                    <td>${listD[current]}</td>                      
                </tr>
            </c:forEach>
        </table>
    </body> 
</html>