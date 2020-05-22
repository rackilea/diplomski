try{   
    Method m = WebView.class.getMethod("findAllAsync", new Class<?>[]{String.class});
    m.invoke(mWebView, findBox.getText().toString());  
} catch(Throwable notIgnored){
    mWebView.findAll();
    try {
        m = WebView.class.getMethod("setFindIsUp", Boolean.TYPE);   
        m.invoke(mWebView, true); 
    } catch (Throwable ignored){}
}