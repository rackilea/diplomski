$http({url: '/url', 
      method: 'POST',
      data: $scope.myFile,
      headers: {'Content-Type': undefined },
      transformRequest: angular.identity
}).success(data){
   $scope.myData = data;

});