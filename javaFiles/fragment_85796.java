$.ajax({
        type : 'POST',
        url : "/fetchOptions/" + region + "/region",
        dataType: "json",
        success : function(data) {
            data = JSON.parse(data);
            //some codes here..
            //use data.lstCountries for Countries List
        },
        error : function(error) {
            alert("Error: " + error.status);
        }
     });