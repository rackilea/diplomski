private fun sendEmail() {
    val contentUri = 
    FileProvider.getUriForFile(context!!,
            "yourPackageAndThen.com.mydomain.fileprovider", 
    File(PATH OF IMAGE or FILE ));

    val emailIntent = Intent(Intent.ACTION_SEND)

    //need this to prompts email client only
    emailIntent.type = "message/rfc822";
    val to = arrayOf("EMAIL ID TO SEND")
    emailIntent.putExtra(Intent.EXTRA_EMAIL, to)
    emailIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
    emailIntent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)

    // attachment Uri comes through camera
    emailIntent.putExtra(Intent.EXTRA_STREAM, contentUri)

    // the mail subject
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Report")
    //email body
    emailIntent.putExtra(Intent.EXTRA_TEXT, MESSAGEforBody)
    startActivity(Intent.createChooser(emailIntent, "Send email using..."))

}