public class SMTPmail {

    public static void sendSMTP(Context context, String message, String subject, String recipted)
    {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{recipted});
        i.putExtra(Intent.EXTRA_CC, "");
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT   , message);

        try {
            context.startActivity(Intent.createChooser(i, "Send mail..."));//crashes here in debug
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }
}