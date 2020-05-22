module.controller('exampleCtrl', function($scope,exampleSvc){

    function loadExternalXml(){
         var x2js = new X2JS();
         exampleSvc.getExternalXml().success(function(data){
              // part to convert xml to json
              var json = x2js.xml_str2json(data);
         });
   }
  });