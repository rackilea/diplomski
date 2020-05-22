$.ajax({
        url: 'upload',
        data: data,
        contentType: false,
        processData: false,
        enctype: 'multipart/form-data',
        type: 'POST',
        success: function(data){
                   alert(data);
                }
       });