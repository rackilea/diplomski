jQuery(document).ready(function($){
        $.ajax({
            url : "/data?name=xml.txt", // Abstract path and filename
            type:"GET", 
            dataType: "text",
            success : function (data) {
               $('<pre />').text(data).appendTo('div');
               window.location.href=contextPath+"http://localhost:8080/subin.html"
            }
        });
      });