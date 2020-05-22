(function() {
    'use strict';

    angular
        .module('app')
        .controller('signController', signController);

    signController.$inject = ['$rootScope', '$scope','listFactory', 'infoService'];

    /* @ngInject */
    function signController($rootScope, $scope, listFactory, infoService) {
        var vm = this;
        var token = $rootScope.token;
        $scope.name = infoService.getName;

        ////////////////

        $scope.signFile = function () {
            var fileId = infoService.getId();
            var Id = fileId.toString();
            var res = document.getElementById("cdigApplet").signFile(Id, '', token);            

            var json = JSON.parse(res);
            if (json.success === true)
            {
                alert("Documento assinado com sucesso! Clique em 'Abrir' para ver a assinatura.");
                $('#sign').modal('hide');
            }
            else
            {
                alert("Documento não assinado!\n" + json.message);
                $('#sign').modal('hide');
            }
        };
    }
})();