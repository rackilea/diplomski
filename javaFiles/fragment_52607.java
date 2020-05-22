Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject here");
            intent.putExtra(Intent.EXTRA_TEXT,"Body Here");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }