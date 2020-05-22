<html>
<head>
<style type="text/css">.thumb-image{float:left;width:100px;position:relative;padding:5px;}.selectedItem{border:2px solid blue;}</style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<div id="wrapper" style="margin-top: 20px;">
<p><b>For deleting thumb-image: click on image to select and press delete button.</b> </p>
<form method="POST" action="upload" enctype="multipart/form-data">
<input id="fileUpload" multiple="multiple" type="file"/> 
<input type="submit" value="Upload">
<button id="btnDelete">Delete</button>
</form>
<div id="image-holder">
</div>
<br/><br/>

</div>

<script>
$(document).ready(function() {

$("#image-holder").on('click','.thumb-image',function(){
   $(this).toggleClass("selectedItem");
});

$("#btnDelete").on("click",function(){
$(".selectedItem").remove();
});

        $("#fileUpload").on('change', function() {
          //Get count of selected files
          var countFiles = $(this)[0].files.length;
          var imgPath = $(this)[0].value;
          var extn = imgPath.substring(imgPath.lastIndexOf('.') + 1).toLowerCase();
          var image_holder = $("#image-holder");
          image_holder.empty();
          if (extn == "gif" || extn == "png" || extn == "jpg" || extn == "jpeg") {
            if (typeof(FileReader) != "undefined") {
              //loop for each file selected for uploaded.
              for (var i = 0; i < countFiles; i++) 
              {
                var reader = new FileReader();
                reader.onload = function(e) {
                  $("<img />", {
                    "src": e.target.result,
                    "class": "thumb-image"
                  }).appendTo(image_holder);
                }
                image_holder.show();
                reader.readAsDataURL($(this)[0].files[i]);
              }
            } else {
              alert("This browser does not support FileReader.");
            }
          } else {
            alert("Pls select only images");
          }
        });
      });
</script>
</body>
</html>