.success (function(data) {
        //ok -> get data

})
.error (function(resp) {
    if (resp.errorCode == 400){
        ...
    }
    ...
    ...
}