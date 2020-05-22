angular.module('jworkApp')
  .controller('AppletCtrl',['$scope', '$sce', function ($scope, $sce) {

            $scope.b64 = 'AAAA';
            $scope.applet = 
                "<APPLET>"+
                "<PARAM name=\"testo\" VALUE=\""+$scope.b64+"\" />"+
                "</APPLET>";

             $scope.getAppletCode = function() {
                  return $sce.trustAsHtml($scope.applet);
             };

  }]);