jQuery(function() { //This is the same that document ready. If you already are in document ready function you shouldnt put this line.
  var move = true;
  jQuery("#flip").hover(function() {
    move = false;
  }, function() {
    move = true;
  });

  setTimeout(function() {
    if(move) {
      var eq = $("#flip").find("li").index($("#flip").find("li.current"));
      eq++;
      if ($("#flip").find("li:eq(" + eq + ")").length == 0)
        eq = 0;
      $("#flip").find("li:eq(" + eq + ")").click();
    }
  }, 600);
});