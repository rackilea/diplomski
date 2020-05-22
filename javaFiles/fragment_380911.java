{
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    emailIntent.setData(Uri.parse("mailto:"));
    emailIntent.putExtra(Intent.EXTRA_EMAIL, "villasantdesign@gmail.com");
    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Resumen");
    emailIntent.putExtra(Intent.EXTRA_TEXT, etModulo.getText()); etAntena.getText(); etCable.getText(); etlugar.getText(); etFecha.getText(); etAmpli.getText();}{;
    Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
    emailIntent.setType("message/rfc822");
    startActivity(Intent.createChooser(emailIntent, "btnEnviar"));}}: