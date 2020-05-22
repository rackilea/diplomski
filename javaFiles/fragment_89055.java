function callMe(count){
$.ajax({
  type: "POST",
  url: "/NewServlet?count=" + count,
  data: { methodToInvoke: "sayHello" , data: "4" }
}).done(function( msg ) {
  alert( "Data Saved: " + msg );
});
}