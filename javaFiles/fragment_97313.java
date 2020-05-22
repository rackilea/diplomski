final String adresaForListener = adresa;

        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Perform action on click   
                Intent activityChangeIntent = new Intent(DatabasesActivity.this, PrikazMape.class);
                activityChangeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                activityChangeIntent.putExtra("add", adresaForListener);

               DatabasesActivity.this.startActivity(activityChangeIntent);
            }
        });