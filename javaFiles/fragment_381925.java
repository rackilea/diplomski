if(submitted){
                    int isbn = Integer.parseInt(request.getParameter("isbn"));     

                    Book b2 = bm.findBook(isbn);           
                    if (b2.getTitle() != null) {
                    %>
                    <table>
                    <tr>
                    <td colspan=2>
                    <h2>Book Found</h2>
                    </td>
                    </tr>

                    <tr>
                            <td><h3>ISBN</h3></td>
                            <td><h3>Title</h3></td>
                    </tr>  

                    <tr>
                            <td><%= b2.getIsbn()%></td>
                            <td><%= b2.getTitle() %></td>
                    </tr>
                    </table>

                    <% }  else { %>
                    <h3> Book Not Found</h3>
                    <% } %> }