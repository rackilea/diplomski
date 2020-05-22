$('form input[type=text]').die('keydown').keydown(function(e){
    if(e.keyCode == 13 ) {
        $('form\\:submitButton').click();
        return false;
    }
});