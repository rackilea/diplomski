function showReport(){
      $.post("reports.action", {repType : "RPDRep" ,selectedProjects :"+ ${projectSelect}+" }, function(data){
        var post_window = window.open();
        $(post_window.document.body).append(data);
      });
     }