function success(data) {
console.log( data );
}
function failure(err) {
console.error( err );
}
ajax( "http://some.url.1", success, failure );