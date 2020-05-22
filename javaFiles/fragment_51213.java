$(document).ready(function(){
    $("form").on("submit", function(event){
        event.preventDefault();

        var formData = JSON.stringify(jQuery("form").serializeArray());
        $.post("directory", formData)
        });
    });