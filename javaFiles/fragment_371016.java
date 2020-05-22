$('#idDistributor').change(function(){
    // Make the ajax request
    $.ajax({
        url: 'path/to/back-bean.action',
        data: "autocompleterValue=" + $(this).val(),
        dataType: "json",
        success: function(data) {    
            // Set the inputs from the json object            
            $('#namaDistributor').val(data.distributor);
            $('#namaPrice').val(data.price);
        }
    });
});