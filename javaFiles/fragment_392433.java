private native void join(String channelKey) /*-{
    var channel = new $wnd.goog.appengine.Channel(channelKey);
    var socket = channel.open();
    $wnd.globalSocket = socket;
    var self = this;

    socket.onmessage = function(evt) {
        var data = evt.data;
        self.@com.divint.roo.client.Channel::onMessage(Ljava/lang/String;)(data);
    };

    socket.onopen = function() {
        self.@com.divint.roo.client.Channel::onOpen()();
    };

    socket.onerror = function(error) {
        self.@com.divint.roo.client.Channel::onError(ILjava/lang/String;)(error.code, error.description);
    };

    socket.onclose = function() {
        self.@com.divint.roo.client.Channel::onClose()();
    };

}-*/;

private native void close() /*-{
    $wnd.globalSocket.close();
}-*/;