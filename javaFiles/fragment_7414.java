teamsApp.controller('testCtrl', function($scope, $http) {
    $scope.title = "This is a testing title";

    $http({
        url: '/getAllPersonsJSON',
        method: "GET",
    }).success(function (data, status) {
            $scope.data = data;
    }).error(function (data, status) {
            $scope.status = status;
    });
});