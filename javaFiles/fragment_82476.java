$(function() {

  var myTableContainer = $("#myTableContainer");

  var renderTable = function(container) { 
    $.get("/table", function(data) {
      container.empty().html(data);
    }
  };

  /* This is called on document ready */
  renderTable(myTableContainer);

  /* Use the same renderTable function when the refresh button is clicked */
  $("#refreshButton").click(function() {
      renderTable(myTableContainer);
  });
}