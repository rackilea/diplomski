function fnRowCallback(){
    var fnRowCallback = function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
        if (aData["rush"] == "Rush" ) {
            nRow.className = nRow.className + " gradeX";  
        }
    };
    return fnRowCallback;
}