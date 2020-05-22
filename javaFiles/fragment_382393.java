$("#popupWindow").dialog();
//After that you can send your form in an ajax request
$.ajax({
   url:url,
   data:$(form).serialize(),
   success:function(data) {
       //dosomething();
    }
});