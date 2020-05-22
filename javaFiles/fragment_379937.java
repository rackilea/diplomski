$('select[name=hostelcampus]').change(function(){

    var campus = $(this).val();

    //Here, make a call to a servlet to get the list of hostel names and,
    // pass the campus ( value of first dropdown ) as a parameter


    //Get a response in the approriate way

    //Assign the list of values to the second dropdown

    //Assuming that you got a string of comma-separated values, 

    var values = response.split(",");

    var hostels = $('select[name=hostelcampus]');

    $.each(values, function(index,value){

         $('option').val(value).text(value).append(hostels);

    })
})