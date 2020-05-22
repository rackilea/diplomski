$(document).ready(function () {
    $.get('ServletControlB',{id:1}, //<-- data object having id as key
        function (responseText) {
          $('#divnombre').text(responseText);
    });
});