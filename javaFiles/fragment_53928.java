<script>
src = "http://code.jquery.com/jquery-latest.js"

var ajax_call = function() {
  $(document).ready(function() {
    var username = $('#user').val();
    $.get('UpdateListsServlet', {
      user: username
    }, function(responseText) {
      $('#TEST').text(responseText);
    });
  });
};

var interval = 3000; //Update every 3s

setInterval(ajax_call, interval);
</script>