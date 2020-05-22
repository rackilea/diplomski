<%@ page import="beans.BookService" %>
<%@ page import="beans.Book" %>
<html>
<body>
<%
    BookService bs = (BookService) new InitialContext().lookup("java:module/BookServiceBean")
    Book b = new Book("Superman");
    bs.createOrUpdate(b);
%>
</body>
</html>