success: function(result){
        if(result!=''){
            $('.myTableWrapper').html(result);
        } else {
            alert(result);
        }
    }