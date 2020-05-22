public static void sendMail(Activity activity, String recipient, String subject, String body)
{
    Intent mail_intent = new Intent(Intent.ACTION_SEND);
    mail_intent.setType("message/rfc822");
    mail_intent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
    mail_intent.putExtra(Intent.EXTRA_SUBJECT, subject);
    mail_intent.putExtra(Intent.EXTRA_TEXT, body);
    activity.startActivity(Intent.createChooser(mail_intent, "Preferovaná aplikácia pre zaslanie e-mailu..."));
}