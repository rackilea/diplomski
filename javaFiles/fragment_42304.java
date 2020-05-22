datePickerDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Today") { dialog, which ->
    val today = Calendar.getInstance()
    (dialog as DatePickerDialog).updateDate(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
    )
    skipDismiss = true;
}