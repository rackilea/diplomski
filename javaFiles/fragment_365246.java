$.ajax({
                    url : https://.../api/long/running/process/start,
                    type : 'POST' , 
                    data : dataform , 
                    success : function(response) {
                        pollForLongRunningStatus(response);
                    },
                    error : function(){
                        alert("error");
                    }
            });
        }

        pollForLongRunningStatus(response) {
           $.post('https://.../api/long/running/process/status', function(data) {
           alert(data);  // update the progress bar
           setTimeout(pollForLongRunningStatus, 1000);
          });
        }