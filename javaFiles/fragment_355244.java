angular.module('scotchy', [])

.config(function($routeProvider, $locationProvider) {

    $routeProvider
        .when('/', {
            templateUrl : 'partials/home.html',
            controller : mainController
        })
        .when('/about', {
            templateUrl : 'partials/about.html',
            controller : mainController
        })
        .when('/contact', {
            templateUrl : 'partials/contact.html',
            controller : mainController
        });

    // use the HTML5 History API
    $locationProvider.html5Mode(true);
});