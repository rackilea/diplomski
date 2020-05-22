FormController.$inject = ['$scope', '$http', '$httpParamSerializerJQLike'];

function FormController($scope, $http, $httpParamSerializerJQLike) {
  $scope.blob = {};
  $scope.submitForm = function() {
    $http({
       method : 'POST',
       url : 'javaAngularJS', // use relative
       data: $httpParamSerializerJQLike($scope.blob),
       headers: {
         'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8;'
       }
     });
   };
}