function wlCommonInit(){
    LoadSQLRecords(); // Upper-case 'L'; should be lower-case.
}

function loadSQLRecords(){
    var invocationData = {
        adapter : 'MySQLadap',
        procedure : 'procedure1',
        parameters : []
    };
};