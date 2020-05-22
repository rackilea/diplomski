donationButton.setOnClickListener(new View.OnClickListener() {
       // here is problem
        @Override
        public void onClick(View view) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{
                    "ethan.reinsch@fillmorecentral.org"
            });
            i.putExtra(Intent.EXTRA_SUBJECT, "Test Subject");
            i.putExtra(Intent.EXTRA_TEXT, "Test Body");
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(DonateActivity.this, "There are no email clients installed.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    });