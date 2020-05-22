(function () {
    //initialization
    var app = angular.module('sbi', []);

    app.controller('PanelController', function () {
        this.tab = 1;

        this.selectTab = function (setTab) {
            this.tab = setTab;
        };
        this.isSelected = function (checkTab) {
            return this.tab === checkTab;
        };
    });
})();

(function ($scope) {

    //edit in your code
    //re-using the already initialized module
    var app = angular.module('sbi');

    function MyCtrl($scope) {

        $scope.reset = function () {
            $scope.requiredField = '';

        };
    };
});