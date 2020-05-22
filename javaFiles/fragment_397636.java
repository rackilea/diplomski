private native String getBlobUrl(String b64)/*-{
    function base64ToBlob(base64) {
        var binary = $wnd.atob(base64);
        var len = binary.length;
        var buffer = new ArrayBuffer(len);
        var view = new Uint8Array(buffer);
        for (var i = 0; i < len; i++) {
            view[i] = binary.charCodeAt(i);
        }
        var blob = new Blob([ view ]);
        return blob;
    };
    var newBlob = base64ToBlob(b64);
    var URLObj = $wnd.URL || $wnd.webkitURL;
    var source = URLObj.createObjectURL(newBlob);
    return source;
}-*/;