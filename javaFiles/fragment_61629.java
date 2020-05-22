// this adds a click event to the first slice
  $("path[data-id='s0']").click(function() {
     alert('you clicked slice one');
  });

  // if you have multiple pie's you can be more specific
  $("#svg svg path[data-id='s0']").click(function(){
     alert('you just clicked pie with id #svg');
  });