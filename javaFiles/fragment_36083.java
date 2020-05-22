module.factory('exampleSvc',function($http){
   var factory = [];

   factory.getExternalXml = function(){
         return $http.get("http://cdn.rawgit.com/motyar/bcf1d2b36e8777fd77d6/raw/bfa8bc0d2d7990fdb910927815a40b572c0c1078/out.xml");
   }

    return factory;
 });