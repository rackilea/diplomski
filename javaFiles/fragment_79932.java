$("#button").on('click', function(){
     var dt=$("#datepicker").show();
     dt.datepicker().on('change', function (ev) {
          $(dt).hide();
    });
   $('html').on('click',function(e){
         if(e.target.id !='button'){
               $(dt).hide();
           }
      });
});