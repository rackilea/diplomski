public void onClick(View v) {
            // Perform action on click   
            Intent activityChangeIntent = new Intent(DatabasesActivity.this, PrikazMape.class);
            activityChangeIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activityChangeIntent.putExtra("add", adresa);

            DatabasesActivity.this.startActivity(activityChangeIntent);
 }