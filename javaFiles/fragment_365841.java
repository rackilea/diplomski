(function() {
    'use strict';
    /* globals SockJS, Stomp */

    angular
        .module('myApp')
        .factory('synchronization_Status', SynchronizationFileTrackerService);

    SynchronizationFileTrackerService.$inject = ['global_WebSocket'];

    function SynchronizationFileTrackerService (global_WebSocket) {
        var stompClient = global_WebSocket;
        var subscriber = {} ;


        return {
            subscribe: subscribe,
            unsubscribe: unsubscribe
        };

        function unsubscribe(target) {
            if (subscriber[target]) {
                subscriber[target].unsubscribe();
            }
        };


        function subscribe(forTarget, handler) {
                if (stompClient.established.established) {
                    subscriber[forTarget] = stompClient.client.subscribe('/synchronization/status/' + forTarget, function(data) {
                        data = angular.fromJson(data.body);
                        handler(angular.fromJson(data));

                    });
                } else {
                    stompClient.connected.promise.then(
                        function() {
                            subscriber[forTarget] = stompClient.client.subscribe('/synchronization/status/' + forTarget, function(data) {
                                data = angular.fromJson(data.body);
                                handler(angular.fromJson(data));

                            });
                        }, null, null);
                }
        }
    }
})();