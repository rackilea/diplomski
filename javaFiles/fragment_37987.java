public class JavaScriptInterface
    {
        Context mContext;

        JavaScriptInterface( Context c ) {
            mContext = c;
        }
        @JavascriptInterface //add this
        public void DoSomething( String dataToPrint )
        {
          .....
        }
}