$(document).ready(function() {
    $(function() {
        $("#country").autocomplete({
            source: function(request, response) {
                $.ajax({
                    url: "/your_webapp_context_here/autocomplete/",
                    type: "POST",
                    data: { term: request.term },

                    dataType: "json",

                    success: function(data) {
                        response(data);
                    }
               });              
            }   
        });
    });
});