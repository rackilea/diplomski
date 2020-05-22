$('#stateSelect').change(function() {
    $.ajax({
        type:"GET",
        url : "/getCitiesForState",
        data : { state: $('#stateSelect').val()},
        success : function(data) {
            $('#citySelect').empty(); //remove all child nodes
            for(var i = 0; i < data.length; i++){
                var newOption = $('<option value=data[i].value>data[i].text</option>');
                $('#citySelect').append(newOption);
            }   
        },
        error: function() {
            alert('Error occured');
        }
    });
});