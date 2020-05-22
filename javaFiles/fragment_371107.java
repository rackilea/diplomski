.directive('enableSave', function() {
  return {
    require: 'ngModel',
    restrict: 'A',
    link: function(scope, elm, attr, ngModel) {
        scope.$watch('modeltowatch', function(newvalue,oldvalue){
          // Enable save button
        })
    }
  }
});