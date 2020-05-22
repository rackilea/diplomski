fun close() {
    mAlertDialog?.let { 
        if (it.isShowing) {
            it.dismiss()
        }
    }
}