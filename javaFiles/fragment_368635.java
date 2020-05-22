// Total cart
      obj.totalCart = function() {
      var totalCart = 0;
      for(var item in cart) {
      totalCart += cart[item].price * cart[item].count;
      }
  //setting value for input field.
    document.getElementById('idofinput').value= Number(totalCart.toFixed(2));
      return Number(totalCart.toFixed(2));
      }