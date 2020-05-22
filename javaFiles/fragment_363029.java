if (window.location.search.indexOf("myparameters") != -1){
            values = window.location.search.substr(window.location.search.indexOf("myparameters"), window.location.search.length);
            values = decodeURIComponent( values );
//some parsing here, didn't include it                  
              $.ajax({
                    url: "JSP2.action?from_redirect=",                     
                    data: {values: values}, 
                    type: "POST",
                    success: function(data) {
                       displayValues(data)
                    }
                });