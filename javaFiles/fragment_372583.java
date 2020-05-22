AlertDialog.Builder alert = new AlertDialog.Builder(YourActivity.this);
            alert.setTitle("Current Booking");
            // This will set the view from XML inside ALertDialog
            alert.setView(alertLayout);
            // disabling cancel of AlertDialog on click of back button and outside touch

            alert.setCancelable(false);

            AlertDialog dialog = alert.create();
            dialog.show();