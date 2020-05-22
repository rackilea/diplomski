(function () {
    var app = angular.module('sbi', []);

    app.controller('PanelController', ['$scope', function($scope) {
        $scope.tab = 1;

        $scope.selectTab = function (setTab) {
            $scope.tab = setTab;
        };

        $scope.isSelected = function (checkTab) {
            return $scope.tab === checkTab;
        };

        $scope.reset = function () {
            $scope.requiredField = '';
        };
    }]);
})();