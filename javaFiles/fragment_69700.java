if(firebaseAuth.getCurrentUser() == null){
        //closing this activity
        finish();
        //starting login activity
        startActivity(new Intent(this, LoginActivity.class));
    }