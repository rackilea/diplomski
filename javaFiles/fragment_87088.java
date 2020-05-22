Parse.Cloud.job("deleteMessages", function(request, status) {

  Parse.Cloud.useMasterKey();

    var ts = Math.round(new Date().getTime() / 1000);
    var tsYesterday = ts - (24 * 3600);
    var dateYesterday = new Date(tsYesterday*1000);

    var query = new Parse.Query("Your Object Class");

    query.lessThan("createdAt", dateYesterday);

    query.find({
        success: function(result) {
            for(var i=0; i<result.length; i++) {
                result[i].destroy({
                    success: function(object) {
                        status.success("Delete job completed");
                        alert('Delete Successful');
                    },
                    error: function(object, error) {
                        status.error("Delete error :" + error);
                        alert('Delete failed');
                    }
                });
            }
            status.success("Delete job completed");
        },
        error: function(error) {
            status.error("Error in delete query error: " + error);
            alert('Error in delete query');
        }
    });
});