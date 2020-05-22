$(function() {
  // make a one-time request
  $.ajax({
    url: "getAllDomains",
    type: "GET",
    contentType: "application/json",
    dataType: "json",
    success: function(data) {
      // init the widget with response data and let it do the filtering
      $("#domainNameId").autocomplete({
        source: data
      });
    },
    error: function(x, t, m) {
      console.trace();
      if (!(console == 'undefined')) {
        console.log("ERROR: " + x + t + m);
      }
      console.log(" At the end");
    }
  });

});