$.ajax({
"url" : ajaxURL,
"success" : function(json) {
    json.bDestroy = true;
    json.sPaginationType = "full_numbers";
    json.sDom = '<"top"<"length"l><"search"f><"position">>rt<"bottom"<"info"i><"pages"p>>';
    oTable = $('#datatable1').dataTable(json);
},
"dataType" : "json"
});