onSelectRow: function (rowid) {
    var operationIds = $(this).jqGrid("getCell", rowid, "operationIds").split(","),
        i, n = operationIds.length;
    gridavail.jqGrid("resetSelection");
    for (i = 0; i < n; i++) {
        gridavail.jqGrid("setSelection", operationIds[i]);
    }
}