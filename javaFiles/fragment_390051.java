$.get('/mywebapp/autocompleteplayer', function(data){
    suggestions = data.data; 
    $('#autocompleted').autocomplete({ // not sure how to use your plugin
        data: suggestions,
        minLength: 3
    });
}, "json");