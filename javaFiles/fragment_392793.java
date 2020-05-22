function myController($scope,$http){
        $scope.save=function(){
            
      var data=$scope.stack;  
       /* post to server*/
        $http.post(url, data)
            .then(
           function(response){
          // success callback
                 }, 
           function(response){
           // failure callback
               });
                               
             }
        }