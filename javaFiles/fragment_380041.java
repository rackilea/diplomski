myApp.directive('html', [function() {
    return {
        restrict: 'E',
        link : function(scope, element, attrs) {
            attrs.$set("lang", "en");    // Set the "lang" value dynamically here
        }
    };
}]);