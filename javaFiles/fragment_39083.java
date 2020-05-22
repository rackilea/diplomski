saveAnalysis = function(analysis)   {
    $http({
        url: 'request-url',
        method: 'POST',
        data: analysis
        })
    .then(function(response)    {
    //HANDLE success
    }, function(errorResponse)  {
    //HANDLE error
    });
};