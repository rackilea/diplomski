function getOfficerInfo(officerUserName) {
    var officerUrl = "/crimeTrack/getOffice/" + officerUserName + ".htm"
    $.ajax({
        url: officerUrl,
        type: "GET",
        success: function(data) {
            $("#form-container").html(data);
        }
    });
}