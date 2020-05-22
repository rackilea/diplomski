myData =  {"a1": first, "a2": second, "a3": third};   

      $.ajax({          
            type : "POST",          
            contentType : "application/json; charset=utf-8",
            url : "${pageContext.request.contextPath}/timeEntry?id=1",
            data :  JSON.stringify(myData), 
            dataType: "json",          
            cache: false,    
            processData:false,
            success : function(response) {
                console.log(response);
            },
            error : function(e) {
                console.log(myData);
               //console.log(jQuery.isPlainObject(myData));
            }
        });