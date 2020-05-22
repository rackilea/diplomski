Uri uri = Uri.parse("mailto:mail@mail.com");
Intent intent = new Intent(Intent.ACTION_SENDTO, uri);

intent.putExtra(Intent.EXTRA_SUBJECT, "email subject"); // optional
intent.putExtra(Intent.EXTRA_TEXT, "email body"); // optional

startActivity(intent);