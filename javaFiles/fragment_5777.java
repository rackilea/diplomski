$(function () {
    $('#jsonPData').hide();
    var json = $("#jsonPData").text();
      $('#tree').jstree({ 'core' : {
            'data' : eval(json)             
        } });     

  });