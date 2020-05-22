$("#overlay").show();

// ...

$('#MainContent').load(url, function() {
  $("#overlay").hide();
});