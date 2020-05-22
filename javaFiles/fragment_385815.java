<% User currentUser = (User) session.getAttribute("currentSessionUser");
                if (currentUser != null){%>
                <tr>
                    <td colspan="2">  
                        <form action="${pageContext.request.contextPath}/cart" method="POST">
                            <input type="hidden" name="productID" value="<%=product.getID()%>" />
                            <input type="submit" value="Add to cart"/>
                        </form>
                    </td>
                </tr>
                 <%} else{%>
                <tr>
                    <td colspan="2">Account required to buy.</td>
                </tr>
            <%} %>