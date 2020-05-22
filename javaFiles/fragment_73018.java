$.ajax({
      url: "Servlet2",
      type: "Post",
      data: {"txtboxvalue":selected},
      dataType: "json",
      success : function(list) {
          // list is the list as Javascript array
      }