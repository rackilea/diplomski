$(document).ready(function () {                           
    $('.btn-checkbox').change(function () {      
        $.get('dataservlet', function (responseJson) {
            var $input = $('#id1');
            var $type = 'checkbox';
            $.each(responseJson, function (key, value) {              
               var append = $('<input type="'+$type+'">'+value+'</input>').attr('id',key).val(value);
               $($input).append('<br/>').append(append); 
            });
        });
    });
});