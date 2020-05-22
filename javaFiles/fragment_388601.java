$.ajax({
    url : "ur_servlet_url" + selRadio,
    type : "POST",
    async : false,
    success : function(data) {
        alert("success");
    }
});