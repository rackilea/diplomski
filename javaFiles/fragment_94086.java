$.ajax({
    type: "POST",
    url: "/controller/deleteTeam",
    data: "teamID=" + team_ID,          
    success: function(response){  
        // we have the response  
        if (response.deleted)
            window.location.replace("/"); // Do the redirect
        } else {
            alert("You can't delete");
        }}, 
    error: function(e){  
          alert('Error: ' + e);  
        }    
 });