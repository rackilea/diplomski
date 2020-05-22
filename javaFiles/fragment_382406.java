//Fill first Dropdown

    $.ajax({
    type:     "GET",
     url: "http://192.168.33.60:8080/countryStateCity?callback=?",
     dataType: "jsonp",
     jsonpCallback: 'jsonCallback',
     cache:false,
    success: function(data) {
        var dataToStore = JSON.stringify(data);
        localStorage.setItem('jsonResults', dataToStore);//Store json to browser local storage
        $("#country").get(0).options.length = 0;
        $("#country").get(0).options[0] = new Option("Select Country", "0");   

        $.each(data, function(index, item) {
            $("#country").get(0).options[$("#country").get(0).options.length] = new Option(item.mfrname, item.countryId);
        });
    },
    error: function(e) {
      //  alert("Error Loading Manufactures");
    }
});



 $("#country").on("change", function (event) { //Change event on country Drop down clear State and City Dropdowns
    var countryId=$("#country").val();
    var stateId=$("#state").val();
    $('#City').find('option').remove().end(); //clear City dropdown and add only select
    $("#City").get(0).options[0] = new Option("--Select--", "0"); 
    $('#state').find('option').remove().end();
    $('#category').find('option').remove().end();

    resetTables();


     var localData = JSON.parse(localStorage.getItem('jsonResults'));// Go to local storage and get state values
    var i = null;
    for (i = 0; localData.length > i; i += 1) {
        if (localData[i].countryId === countryId) {
              $.each(localData[i].states, function(index, value) {
               $("#state").get(0).options[$("#state").get(0).options.length] = new Option(value.description, value.code);
            });
        }
    }

 });     
$("#state").on("change", function (event) {//State change event clear city then go to 
    var countryId=$("#country").val();
    var stateId=$("#state").val();
 // alert(countryId!="0"&&stateId!="0");
     $('#City').find('option').remove().end();
    $("#City").get(0).options[0] = new Option("--Select--", "0"); 
    $('#category').find('option').remove().end();
    resetTables();
    if(countryId!="0"&&stateId!="0"){
    //now call the citys Rest call   
    $.ajax({
        type:     "GET",
         url: "http://192.168.33.60:8080/cities?countryId="+countryId+"&stateId="+stateId+"&callback=?",
         dataType: "jsonp",
         jsonpCallback: 'jsonCallback',
         cache:false,
        success: function(data) {
            jsonResults=data;
              $.each(data, function(index, item) {
                   $("#City").get(0).options[$("#City").get(0).options.length] = new Option(item.description, item.code);
            });
        },
        error: function(e) {
          //  alert("Error Loading cities");
        }
    });
}  else{
    $("#City").get(0).options[0] = new Option("--Select--"+countryId, "0"); 
}