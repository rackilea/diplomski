$("#task-list-table").jqGrid({
    autowidth: true,
    datatype : "json",
    url: "task-management.html",
    mtype: 'POST',
    colNames : ["Title","Order ID","Realty","Building",
                "Priority","Action","Assignee"],
    colModel : [
        {label: "Title",   name: "title",   index: "Title"},
        {label: "OrderID", name: "orderId", index: "OrderID", jsonmap: "orderId"},
        {label: "Realty",  name: "realty",  index: "Realty",  jsonmap: "realty" },
        {label: "Building",name: "building",index: "Building",jsonmap: "building"},
        {label: "Priority",name: "priority",index: "Priority",jsonmap: "priority"},
        {label: "Action",  name: "action",  index: "Action",  jsonmap: "action"  },
        {label: "Assignee",name: "assignee",index: "Assignee",jsonmap: "assignee"}
    ],
    sortname : "Title",
    sortorder : "desc",
    shrinkToFit: true,
    viewrecords: true,
    jsonReader : {
        repeatitems : false
    },
    onSelectRow: function(){
        alert(jQuery("#task-list-table").getGridParam('selrow'));
    });