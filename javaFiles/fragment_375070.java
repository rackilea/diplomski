private void openSubActivity() {        

        Intent intent = new Intent(MainActivity.this,SubActivity.class);
       intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);

    }