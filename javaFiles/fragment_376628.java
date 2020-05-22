$.ajax(
  {
    type: "POST", 
    url: "/TestServlet",
    data: { tv_zip: '90210' }, // zipcode
    dataType: "json",
    success: function(response) {
      // replace the contents of div with id=some_div with the response.
      // You will want to format / tweak this.
      $('#some_div').html(response); 
    },
    error: function(xhr, ajaxOptions, thrownError) { alert(xhr.responseText); }
  }
);