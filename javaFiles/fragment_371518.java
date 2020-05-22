// Copy data to element
mWebView.loadUrl("javascript:(function() { " +  
        "document.getElementById('" + mElementId + "').value = '" + 
        someData.replace("'", "\'") + "'; " +
        "document.getElementById('" + mElementId + "').onchange();" +
        "})()");