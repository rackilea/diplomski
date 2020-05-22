success:function(fileList) {
   var uploadedFiles = []
   fileList.forEach(function(file){
       if (file.success) uploadedFiles.push(file.name)
     })
   }
   alert("Files uploaded: " + uploadedFiles.join(", ");