$(function(){
    $(".update").click(function(){
        var id_update = $(this).attr("id_update");
        var users = $("#row_" +  id_update).find(".users").text().split("|").slice(1,-1);
        for(var user in users)
            alert(users[user]);
    });
});
// tested on Windows 7 with Chrome 33+