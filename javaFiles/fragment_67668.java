$('#tableid').dataTable({
    "processing": true,
    "destroy": true,
    "data": data,
    "columns": [
       { 
          "data": "serviceName" 
       },
       { 
          "data": "requestXML",
          "render": function(data, type, full, meta){
              return $('<div/>').text(data).html();
          }
       }
    ]
});