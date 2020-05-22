function casetest {


    jQuery(document).ready(function() {
        jQuery(function() {
                jQuery("#Caant, #CaseInporney, #CaseInput_employer, #CaerAttorney").autocomplete({





                source : function (request, response) {
                jQuery.ajax({
                        url : "page.request.do?page=page.ajax.autocomplete",
                        type : "GET",
                        data : {
                                term : request.term
                        },
                        dataType : "json",
                        success : function(data) {  


                               console.log(data);

                                response(data);

                        }

                });
        }, 


      focus: function( event, ui ) {
          jQuery(this).val(ui.item.label);
          jQuery(this).val(ui.item.value);


        return false;
      },  
       select: function( event, ui ) {


          jQuery(this).val(ui.item.label);
          jQuery(this).val(ui.item.value);

        return false;
      }


})

jQuery.ui.autocomplete.prototype._renderItem =  function( ul, item ) 
       {
         return jQuery( "<li>" )
         .append( "<a>" + item.label + " " + item.desc + "</a>" )
         .appendTo( ul );
       };

});
});


}