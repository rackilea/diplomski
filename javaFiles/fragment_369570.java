$('#loaderImage').show();

$scope.sampleJSONClass = {};
$scope.sampleJSONTrigger = {};
$scope.sampleJSONPages = {};
oboe('/utilities/longProcessStream')
    .done(function(data) {
        var dataFromServer = data.pmdStructureWrapper;
        if (Object.keys(dataFromServer)[0].endsWith('.cls')) {
            $scope.sampleJSONClass[Object.keys(dataFromServer)[0]] = Object.values(dataFromServer)[0];
        }
        if (Object.keys(dataFromServer)[0].endsWith('.trigger')) {
            $scope.sampleJSONTrigger[Object.keys(dataFromServer)[0]] = Object.values(dataFromServer)[0];
        }
        if (Object.keys(dataFromServer)[0].endsWith('.page')) {
            $scope.sampleJSONPages[Object.keys(dataFromServer)[0]] = Object.values(dataFromServer)[0];
        }
        $scope.$apply();
        $('#loaderImage').hide();
    })
    .fail(function() {
        console.log('error');
    });