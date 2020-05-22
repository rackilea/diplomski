(function() {
    'use strict';
    /* globals SockJS, Stomp */

    angular
        .module('myApp')
        .factory('global_WebSocket', GlobalWebSocketClient);

    GlobalWebSocketClient.$inject = ['$window', 'localStorageService', '$q'];

    function GlobalWebSocketClient($window, localStorageService, $q) {

        var connected = $q.defer();

        var established = {established: false} ;

        var loc = $window.location;
        var url = loc.protocol + '//' + loc.host + loc.pathname + 'websocket';
        var token = localStorageService.get('token');
        if (token && token.expires_at && token.expires_at > new Date().getTime()) {
            url += '?access_token=' + token.access_token;
        } else {
            url += '?access_token=no token';
        }

        /*jshint camelcase: false */
        var socket = new SockJS(url);


        /*jshint camelcase: false */
        var stompClient = Stomp.over(socket);
        var headers = {
            Authorization : 'Bearer ' + token.access_token,
        };

        stompClient.debug = null;


        var establishConnection = function() {
            stompClient.connect(headers, function() {
                established.established = true;
                connected.resolve('success');
            }, function(error) {
                console.log("ERROR CONNECTNG!");
                console.log(error.headers);
                establishConnection();
            });
        };


        establishConnection();



        return {
            connected: connected,
            client: stompClient,
            established: established
        };
    }
})();