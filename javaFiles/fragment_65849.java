$.ajax({
        type: "POST",
        url: "/registration",
        data: userData ,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(data){ document.location.href='/page_of_user'; },
        failure: function(errMsg) {
            alert(errMsg);
        }
  });