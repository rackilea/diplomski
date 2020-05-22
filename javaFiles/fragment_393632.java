$.ajax(
     url : url,   // Controller URL
     success: function(resultJSON){
          //Assign resultJSON to myFruits variable
          $scope.myFruits = resultJSON;
      }});