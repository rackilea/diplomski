val datePickerDialog = object : DatePickerDialog(
        this@MainActivity,
        settings.currentTheme,
        DatePickerDialog.OnDateSetListener { _, chosenYear, chosenMonth, dayOfMonth ->
            calendar.set(Calendar.YEAR, chosenYear)
            calendar.set(Calendar.MONTH, chosenMonth)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            text_view_chosen_date.text = SimpleDateFormat("dd/MM/yyyy", Locale.US).format(calendar.time)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
) {
    override fun dismiss() {
        if (!skipDismiss) {
            super.dismiss()
        } else {
            skipDismiss = false
        }
    }
}