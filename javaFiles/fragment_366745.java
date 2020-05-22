function wlCommonInit(){
}

function getXML() {
    var invocationData = {
        adapter : 'JavaAdapter',
        procedure : 'getXML',
        parameters : []
    };

    WL.Client.invokeProcedure(invocationData, {
        onSuccess : successHandler,
        onFailure : failureHandler
    });
}

function successHandler(data) {
    alert(JSON.stringify(data));
}
function failureHandler(data) {
    alert("Error to get data");
}