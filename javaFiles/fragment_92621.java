// Run on page load
    window.onload = function() {

        // If sessionStorage is storing default values (ex. name), exit the function and do not restore data
        if (sessionStorage.getItem('Environment') == "Environment" ) {
            return;
        }

        // If values are not blank, restore them to the fields
        var Environment = sessionStorage.getItem('Environment');
        if (Environment !== null) $('#Environment').val(Environment);

        var DataFilter = sessionStorage.getItem('DataFilter');
        if (DataFilter !== null) $('#DataFilter').val(DataFilter);

        var InUse= sessionStorage.getItem('InUse');
        if (InUse!== null) $('#InUse').val(InUse);

        var DataUsage= sessionStorage.getItem('DataUsage');
        if (DataUsage!== null) $('#DataUsage').val(DataUsage);
    }

    // Before refreshing the page, save the form data to sessionStorage
    window.onbeforeunload = function() {
        sessionStorage.setItem("Environment", $('#Environment').val());
        sessionStorage.setItem("DataFilter", $('#DataFilter').val());
        sessionStorage.setItem("InUse", $('#InUse').val());
        sessionStorage.setItem("DataUsage", $('#DataUsage').val());
    }