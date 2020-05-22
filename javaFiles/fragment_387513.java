myApp.controller('myCtrl', function($scope,$window,$location) 
{
    // watch for location changing
    $scope.$on('$locationChangeStart', function() {
        var d = $scope.action.buttonClicked;

        // if there isn't any clicked button
        if (!Object.keys(d).map(function(k) { return d[k]; }).some(angular.identity)) {
            // redirect to main page
            $location.url('/');
        }
    });

    ...
}