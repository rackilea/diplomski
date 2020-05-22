Intent intent = new Intent(Intent.ACTION_SEND);  

intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mail@mail.com"});
intent.putExtra(Intent.EXTRA_SUBJECT, "email subject"); // optional
intent.putExtra(Intent.EXTRA_TEXT, "email body"); // optional
intent.setType("message/rfc822"); // useful define which kind of app to perform the action 

startActivity(Intent.createChooser(intent, "Send Email"));