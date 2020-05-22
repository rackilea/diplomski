$scope.getTraineeStatus = function () {
    // assuming the HTTP API is: GET http://example.com/traineeStatus
    $http.get('http://example.com/traineeStatus', config)
        .success(function (data) {
            $scope.traineeStatus = data;
        })
        .error(function (err) {
            // handle error
        });
}