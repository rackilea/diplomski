angular.module('localizeApp')
    .constant("baseURL", "/loc/")

    .service('LocalizeData', ['$http', 'baseURL', function ($http, baseURL) {

        this.getConfig = function () {
            return $http.get(baseURL + "config");
        };