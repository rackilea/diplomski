public class webViewInterface { 
    //@JavascriptInterface //for SDK 12+
    public String showToast(String myText) {
        Toast.makeText(context, myText, Toast.LENGTH_LONG).show();
        return myText;
    }
    }