@BindingAdapter(value = "visiblity")
@JvmStatic
fun showHide(view : View, show : Boolean){
    view.visibility = when {
        show -> View.VISIBLE
        else -> View.GONE
    }
}