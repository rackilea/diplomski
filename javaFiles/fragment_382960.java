$.ajax({
    url : "http://localhost:3000/users/" + $("#deleteUserIdInput").val(),
    datatype : "json",
    method : "DELETE",
    contentType : "application/json",
    error:function(data){
        console.log(data.entity);
    }
}).done(function(data) {
        console.log(data.entity)
    }
);