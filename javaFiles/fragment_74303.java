$http({
 'url' : 'http://localhost:9090/QuantumM/orbital/sendstatement/',
    'method' : 'POST',
    'headers': {'Content-Type' : 'application/json'},
    'data' : $scope.clnfamilyArray
}).success(function(data){ // The data is passed here when received
    console.log(data);
})