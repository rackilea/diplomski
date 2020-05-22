$.ajax({
  type: "POST",
  url: "http://localhost/testing.php",
  data: { name: "John Doe" } // sample data sent to server
}).done(function( msg ) {
  alert( "Response data: " + msg );
});