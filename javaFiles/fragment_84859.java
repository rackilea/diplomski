$(function(){

    var ischecked=$("#foo").is(':checked'); 
   if(ischecked)
   {
       $("#checked-a").fadeIn(200);
   } 
    else
    {
        $("#checked-a").fadeOut(200);   
     }

});