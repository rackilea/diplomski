describe('Test', function (){
    beforeEach(module('myApp'));
    var $controller;

    beforeEach(inject(function(_$controller_, _$httpBackend_){
          $controller = _$controller_;
          $httpBackend =_$httpBackend_;
          $scope = {};
    }));

    /*makeURLParameters*/
    it('Testing [fController]: :  makeURLParameters 1, default', function(){
        var controller = $controller('fController', { $scope: $scope });

        expect($scope.makeURLParameters()).toEqual("?page=0&size=15&sort=code&order=asc");
    });
});