companion object {
        fun hideSoftKeyboard(activity: Activity, view: View?) {
            view?.let {
                 val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.applicationWindowToken, 0)
            }
        }
    }