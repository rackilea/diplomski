final Toast toast = Toast.makeText(getBaseContext(), "Word is not availabe",
            Toast.LENGTH_LONG);
    toast.show();
    toast.getView().postDelayed(new Runnable() {

        @Override
        public void run() {
            startActivity(new Intent(getBaseContext(), YourNewActivity.class));
        }
    }, 4000);