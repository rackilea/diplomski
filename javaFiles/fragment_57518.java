$.ajax({
   type: "POST",
   url: "cart.jsp",
   data: "p_id=SKU001&quantity=4",
   success: function(msg){
     alert( "FOUR SKU001 ADDED TO CART");
   }
 });