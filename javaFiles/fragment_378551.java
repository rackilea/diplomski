success: function(response)
  {
     if(typeof response==='object') 
     {
        var $select = $('#state');
        $select.find('option').remove();
        $('<option>').val("-1").text("Select").appendTo($select)
        $.each(response, function(key, value) {
        $('<option>').val(key).text(value).appendTo($select);
     }
  },