$('document').ready(function() {

  $('#input_id').bind('keyup', function(e) {
    console.log($('#input_id').val());
    if ((/[_0-9]$/i).test($('#input_id').val())) {
      $('p').html("true");
    } else {
      $('p').html("false");
    }

  });

});