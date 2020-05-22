public void navigate(driver, method, path, body) {
  String JS_NAVIGATE_REQUEST =
    "(function(method, path, body, callback){  " +
    "    var xhr = new XMLHttpRequest();       " +
    "    xhr.open(method, path, true);         " +
    "    xhr.onloadend = function(){           " +
    "      document.write(xhr.responseText);   " +
    "      document.close();                   " +
    "      callback();                         " +
    "    };                                    " +
    "    document.write('');                   " +
    "    xhr.send(body);                       " +
    "}).apply(window, arguments);              " ;

  ((JavascriptExecutor)driver).executeAsyncScript(JS_NAVIGATE_REQUEST, method, path, body);
}