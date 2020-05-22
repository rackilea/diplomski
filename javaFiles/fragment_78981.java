<form method="POST" action="servlet" onsubmit="selectAll">
<div id="products-container">
    //I use this list to pick the things I want
    <select id="product-list" size="26" onclick="addToList(this)">
    <%
      List<Product> product = ProductDao.loadProducts();
      for(int i = 0; i < product.size(); i++){
    %>
    <%
      out.write(
       "<option value=\"" + product.get(i).getProductId() + "\">"
       + product.get(i).getProductName() + "</option>");
    %>
    <%
      }
    %>
    </select>
</div>
<div id="cart-container">
    //I use this list to save all the things I already picked, 
    //if I double click an item on the list, it removes said item
    <select id="cart" size="10" name="cart" onDblClick="removeFromList()" multiple>
    </select>
</div>
    <input type="submit" value="Buy">
</form>