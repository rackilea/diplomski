$scope.createAgency = function(agency) {
    AgencyService.createAgency(agency)
        .then(
                $scope.getAllAgencies,
            function(errReponse){
                console.error('Error while creating Agency.');
            }
        );
};