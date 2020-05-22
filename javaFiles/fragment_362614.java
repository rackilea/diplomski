data.append('file', dataURItoBlob(canvas.toDataURL("image/jpeg", function(){
            $.ajax({
                url: 'upload',
                data: data,
                contentType: false,
                processData: false,
                type: 'POST',
                success: function(data){
                    alert(data);
                }
            }); 
  })));