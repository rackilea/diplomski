function wrapRequest(xmlRequest) {
    var oldSend = xmlRequest.prototype.send;
    xmlRequest.prototype.send = function() {
        var oldOnReady = this.onreadystatechange;
        oldOnReady = function() {
            oldOnReady.apply(this, arguments);
            // if call is complete, decrement counter.
        }
        // increment counter
        if(oldSend.apply)
            oldSend.apply(this, arguments);
        else if (oldOnReady.handleEvent) { //Firefox sometimes will need this
            oldOnReady.handleEvent.apply(this, arguments);
        }
    }
}