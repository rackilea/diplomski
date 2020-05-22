Intent shareIntent = ShareCompat.IntentBuilder.from(this)
                    .setType("text/plain")
                    .setSubject("ShareCompat")
                    .setText("I am using ShareCompat class")
                    .setChooserTitle("Sending Text")
                    .createChooserIntent();

if (shareIntent.resolveActivity(getPackageManager()) != null)
    startActivity(shareIntent);