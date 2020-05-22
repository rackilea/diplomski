.controller('TeamsCtrl', function($scope) {  

    var text = '{"employees":[' +
        '{"name":"John Doe"},' +
        '{"name":"Sam Doe"},' +
        '{"name":"Jack Doe"}]}';  
    /* create scope property that will be recognized in view*/
    $scope.tasks =  JSON.parse(text);

});