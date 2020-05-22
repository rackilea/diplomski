function updateProgrammerDetails(site, Id) {
    $.post('EngineAdminServlet', {
        action: "updateProgrammerMenu",
        siteDetails: site,
        ID: Id,
    }, function(data, status) {
        var pid, name, sky, ip, eleven;
        // work with the object in 'data' here, E.g:
        console.log(data.ID, data.siteName); // = 123, 'VEGAS'
    }).fail(function(error) { 
        alert("Error retrieving details from server");
    }); //end ajax call
}