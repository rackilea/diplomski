$(document).ready(function(){
    $('#uploadImage').click(function(){
      var form = $('#uploadform');
        $.ajax({
          type: 'Post',
          url: 'UploadImage',
          data: form.serialize(),
          enctype: 'multipart/form-data',
          success: function(result) {
            $('#uploadResult').html(result);
          }
        });
    });
  });