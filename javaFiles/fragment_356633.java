AlertDialog.Builder(this).apply {
    setMessage(getString(R.string.alert_dialog_main_activity))
    setView(editText)
    setOnDismissListener {
        if(/*TODO validate phone number*/)
        (it as AlertDialog).show()
    }
    setPositiveButton("Done", { dialogInterface, i ->
        toast(editText.text.toString())
        PreferenceManager.getDefaultSharedPreferences(applicationContext).edit().putInt("phoneNumber", editText.text.toString().toInt()).commit()

    })
    show()
}