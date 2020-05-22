<% for (NewsDoc news : newsList) { %>
    <h2><%=news.getTitle()%></h2>
    <p>
        <%=news.getAbout()%>
    </p>
<% } %>