function addUser(currentProjectId, selectedUserId) {

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/addUserToProject",
        data :{ projectId: currentProjectId, userId: selectedUserId}, 
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
        },
        error : function(e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done : function(e) {
            console.log("DONE");
        }
    });
}