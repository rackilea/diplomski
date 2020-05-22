$.ajax(
               {
                   type: "get",
                   url: "CallTimer", //Your full URL goes here
                   data: { name: name1, date: date1,hour:hour1,filepath:filepath1,minute:minute1},
                   success: function(data, textStatus, jqXHR){
                       alert("success");                  
                   },
                   error: function(jqXHR){
                       alert(jqXHR.responseStatus);
                   }
               });