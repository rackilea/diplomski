$scope.submit = function(patientData)
            {
             $http.post('searchPatientResult', patientData).success(function(data) {
                    $scope.user = data;
                    console.log($scope.user);

                });
    };