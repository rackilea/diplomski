$(document).ready(function() {
        $('#feedName').blur(function() {
            var feedName=$("#feedName").val();
            if(feedName!="")
            {
                $.ajax( {
                      traditional: true,
                      type: "POST",      
                      url: "feedCheck",
                      data:"feedName="+feedName,
                      dataType: "text",
                      success: function(data, success) {
                          if(data.indexOf("success")==-1){
                                  alert("Action returned Error")
                           }else{
                                 alert("Action returned Success") 
                           }
                      }      
                    });
            }
        });
    });