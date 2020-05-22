$http({
        method: 'POST',
        url: '/api/authentication',
        headers: {'Content-Type': 'application/x-www-form-urlencoded'},
        data: 'username=' + $scope.email + '&password=' + $scope.password
    });