$(".na").on("click", function(){
  
  // Remove the class under from all p element.
  $(".na").removeClass("under");
  
  // Add the class under to the one clicked.
  $(this).addClass("under");
});