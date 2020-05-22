this.getImageList = function(){
var defer = $q.defer();
    var imageListPromise =  http.get('/projectName/showImage');
    imageListPromise.then(function(result){ 
        imageList = result.data;    
        defer.resolve(imageList);
    });
return defer.promise;
};