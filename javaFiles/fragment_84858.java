$("#foo").change(function(){

   var ischecked=$(this).is(':checked'); 
    if(ischecked)
    {
         $("#checked-a").fadeIn(200);
    }
    else
    {
        $("#checked-a").fadeOut(200);   
     }

});