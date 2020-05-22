$(document).ready(function(){
        $("#teamMemNum").on('change paste keyup', function(){
            $("#memNameTable").html("");
            
            var num = $("#teamMemNum").val();
            var markup = "<tr><td><label for='memName'>Enter name: </label></td><td><input type='text' name='memName' id='memName'></td><td></td><td></td></tr>";
            for(var i = 0; i < num; i++){
                $("#memNameTable").append(markup);
            }
        });
    });