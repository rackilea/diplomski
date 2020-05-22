function callMe(){
    $.ajax({
      type: "POST",
      url: "/someServlet",
      data: { param1: "val1" , param2: "val2" }
    }).done(function( data) {
       //TODO
    });
}