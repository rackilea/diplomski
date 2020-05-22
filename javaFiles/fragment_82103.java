case class TypedResource[T](id: Int)

object TR {
  object id {
    val my_webview = TypedResource[TextView](R.id.my_webview)
    val my_textview = TypedResource[WebView](R.id.my_textview)
    //... you must put here all your typed views referenced by id
  }
}

trait TypedViewHolder {
  def view: View
  //the method explicitly casts to the needed resource type based on the argument
  def findView[T](tr: TypedResource[T]): T = view.findViewById(tr.id).asInstanceOf[T]
}

object TypedResource {
  //this will implicitly convert your views to a corresponding TypedViewHolder
  //this lets you avoid explicit type cast to get your view
  implicit def view2typed(v: View): TypedViewHolder = new TypedViewHolder { def view = v }
}