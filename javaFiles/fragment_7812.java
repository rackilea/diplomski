angular.module('admintool.services', []).factory('UserService', ["$http", "CONSTANTS", function($http, CONSTANTS) {
    var service = {};
    service.checkUser = function (userDto) {
        return $http.post(CONSTANTS.checkUser, userDto).then(function (value) {
                window.location.href = "/";
        }).catch(function (reason) { window.location.href = "/register" });
    };
    return service;
}]);