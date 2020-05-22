$.ajax({
    type : "GET",
    url  : "<s:url action='selectstate'/>",
    dataType : 'text/javascript',
    data : {'name' : $("#selectedCountry").text()},
    success : function(result){
      if (result != null && result.length > 0){
        $("statesdivid").html(result);
      }
    },
    error : function(xhr, errmsg) {alert("No values found..!!");}
});