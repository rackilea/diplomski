$('#LogTable').dataTable({
   "bProcessing" : true,
   bServerSide : true,
   sAjaxSource : "./log!lList.action",
   sServerMethod : "POST",
   "columns": [
       { "data": "LogId" },
       { "data": "tableName" },
       { "data": "columnName" },
       { "data": "oldValue" },
       { "data": "newValue" },
       { "data": "changeTypeText" },
       { "data": "changedByName" },
       { "data": "changedOn" },
    ]
});