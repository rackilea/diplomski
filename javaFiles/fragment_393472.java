.controller('RegisterController', ['$scope', '$resource', function($scope, $resource) {

    var auth = $resource('/auth/:action', null, {
        login: {
            method: 'POST',
            params: {
                action: 'login'
            },
        },
        register: {
            method: 'POST',
            params: {
                action: 'register'
            }
        }
    });


    $scope.AddUser =  function() {

        // your data consumed from UI
        var data = {
            name: $scope.name
            lastname: $scope.lastname,
            login: $scope.login,
            pass: $scope.pass,
            age: $scope.age,
            gender: $scope.gender
        }; 

        auth.register(null, data, function(resp) {
            // your callback when response is received
            // resp variable contains response data sent from server
            if (resp.status) {
                // registered successfully
            } else {
                // some error occurred
            }
        });
    };

}]);