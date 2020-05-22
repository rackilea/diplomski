String whatsAppMessage = message.getText().toString();
Uri uri = Uri.parse("smsto:" + "9888873438");
Intent i = new Intent(Intent.ACTION_SENDTO, uri);
i.putExtra(Intent.EXTRA_TEXT, whatsAppMessage);
i.setPackage("com.whatsapp");
startActivity(Intent.createChooser(i, ""));