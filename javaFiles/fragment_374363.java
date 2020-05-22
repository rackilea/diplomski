$.ajax({
         url: "Alert",
         //type: "post",
         data: objectArray,
         cache: false,
         success: function(data) {
             $("#place-for-alert").html(data);
         }
    });