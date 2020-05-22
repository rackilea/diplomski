class MyFragment extends Fragment {
  private var myWebView: Option[WebView] = None
  private var myTextView: Option[TextView] = None

  override def onCreateView(
    inflater: LayoutInflater, 
    container: ViewGroup, 
    savedInstanceState: Bundle): View = {
      //imports the implicit conversion
      import TypedResource._

      val myView = inflater.inflate(R.layout.my_view, container, false)
      myWebView = Some(myView.findView(TR.id.my_webview))
      //now we're using options, so we must call methods on the inner value
      //we can use Option.map(...) to do it [see http://www.scala-lang.org/api/current/index.html#scala.Option]
      myWebView.map(_.loadUrl("http://www.google.com/"))

      myTextView = Some(myView.findView(TR.id.my_textview))
      //same as above
      myTextView.map(_.setText("Google.com"))
      myView
  }
}