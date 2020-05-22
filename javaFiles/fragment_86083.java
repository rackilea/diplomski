$.ajax({  
                    url:'JsonServlet?userid='+document.getElementById("uid").value,  
                    type:'post', 
                    dataType: 'json',  
                    success: function(data) {  

                        $('#uname').val(data.uname);  
                        $('#uadd').val(data.uadd);
                    }  
                });  
            });