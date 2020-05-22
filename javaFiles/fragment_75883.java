$.post('/url', {
        'filters.field1': 'value1',
        'filters.field2': 'value2'
    },     
    function(data){
        alert(data);
    }
);