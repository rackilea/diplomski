$http({
    url : "pathserver/writenotification",
    method : "POST",
    data : obj,
    headers : {
        "Content-Type" : "application/json; charset=utf-8",
        "Accept" : "application/json"
    }
}).success(function(data) {
    $scope.items = data;
    alert('Notifica inviata');
}).error(function(data) {
    alert('Invio notifica fallito');
});