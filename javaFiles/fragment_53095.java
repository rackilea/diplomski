$("form#myForm").on('submit', function() {
   var ids = $('#ids').val(); //get values of <form:hidden path="ids"/> ,values will look like: 1,2,3,4,5
   var idsArray = ids.split(","); //split by comma
   var result = jQuery.inArray($('#id').val(), idsArray);//check user entered id exists in ids array
    if(result==-1){ 
        $('#idErr').hide();
        return true; //id not exists, submit form
    }
    else {
        //id exists, show error message
        $('#idErr').show();
        return false;
    }
});