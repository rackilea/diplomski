class SendEmail {
    Context context;

    public SendEmail(Context context){
        this.context = contex;
    }

    //send an email
    public void send(String email) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
        "mailto", email, null));
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "Body of message");
        context.startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }
}