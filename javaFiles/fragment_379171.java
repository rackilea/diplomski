angular
    .module('myApp', ['prettyXml'])
    .controller('xmlController', function($scope, $http){

        $http.get("/api/xml").then(function (response) {
            $scope.xml = response.data; //I need to PRETTIFY IT HERE ON $scope.xml
        });
    });