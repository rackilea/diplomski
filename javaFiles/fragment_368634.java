function displayCart() {
  ..
  $('.show-cart').html(output);
 <!--here you got that total price-->
  $('.total-cart').html(shoppingCart.totalCart());
  $('.total-count').html(shoppingCart.totalCount());
  }