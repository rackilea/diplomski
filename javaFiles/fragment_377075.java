<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
BufferedImage bImage = ImageIO.read(new File("/home/visruth/Desktop/Visruth.jpg"));//give the path of an image
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write( bImage, "jpg", baos );
baos.flush();
byte[] imageInByteArray = baos.toByteArray();
baos.close();
String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
%>

<div>
    <p>As of v6, Java SE provides JAXB</p>
    <img src="data:image/jpg;base64, <%=b64%>" alt="Visruth.jpg not found" />
</div>          
</body>
</html>