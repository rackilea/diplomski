app.factory('channelService', ['$http', '$rootScope', '$timeout',
  function($http, $rootScope, $timeout) {
    var service = {};
    var isConnectionAlive = false;
    var callbacks = new Array();
    var retryCount = 0;
    var MAX_RETRY_COUNT = 3;

    service.registerCallback = function(pattern, callback) {
      callbacks.push({pattern: pattern, func: callback});
    };

    service.messageCallback = function(message) {
      for (var i = 0; i < callbacks.length; i++) {
        var callback = callbacks[i];
        if (message.data.match(callback.pattern)) {
          $rootScope.$apply(function() {
            callback.func(message);
          });
        }
      }
    };

    service.channelTokenCallback = function(channelToken) {
      var channel = new goog.appengine.Channel(channelToken);
      service.socket = channel.open();
      isConnectionAlive = false;
      service.socket.onmessage = service.messageCallback;

      service.socket.onerror = function(error) {
        console.log('Detected an error on the channel.');
        console.log('Channel Error: ' + error.description + '.');
        console.log('Http Error Code: ' + error.code);
        isConnectionAlive = false;
        if (error.description == 'Invalid+token.' || error.description == 'Token+timed+out.') {
          console.log('It should be recovered with onclose handler.');
        } else {
          // In this case, we need to manually close the socket.
          // See also: https://code.google.com/p/googleappengine/issues/detail?id=4940
          console.log('Presumably it is "Unknown SID Error". Try closing the socket manually.');
          service.socket.close();
        }
      };

      service.socket.onclose = function() {
        isConnectionAlive = false;
        console.log('Reconnecting to a new channel');
        openNewChannel();
      };

      console.log('A channel was opened successfully. Will check the ping in 20 secs.');
      $timeout(checkConnection, 20000, false);
    };

    function openNewChannel(isRetry) {
      console.log('Retrieving a clientId.');
      if (isRetry) {
        retryCount++;
      } else {
        retryCount = 0;
      }
      $http.get('/rest/channel')
          .success(service.channelTokenCallback)
          .error(function(data, status) {
            console.log('Can not retrieve a clientId');
            if (status != 403 && retryCount <= MAX_RETRY_COUNT) {
              console.log('Retrying to obtain a client id')
              openNewChannel(true);
            }
          })
    }

    function pingCallback() {
      console.log('Got a ping from the server.');
      isConnectionAlive = true;
    }

    function checkConnection() {
      if (isConnectionAlive) {
        console.log('Connection is alive.');
        return;
      }
      if (service.socket == undefined) {
        console.log('will open a new connection in 1 sec');
        $timeout(openNewChannel, 1000, false);
        return;
      }
      // Ping didn't arrive
      // Assuming onclose handler automatically open a new channel.
      console.log('Not receiving a ping, closing the connection');
      service.socket.close();
    }

    service.registerCallback(/P/, pingCallback);
    openNewChannel();

    return service;
  }]);