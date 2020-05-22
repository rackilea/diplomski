$.ajax({
        url : "/login",
        type : "post",
        data : {
            "reviewID" : review_ID 
        },
        success : function(data) {
            alert(data);
        ...
        }
 });