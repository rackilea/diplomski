$('#screenId').click(function() {
    $.ajax({
         type: "GET",
         cache: false,
         url: "yourControllerURL",
         data: "",
         success: function(response){
             $('#container').html(response);
         }
    });
});