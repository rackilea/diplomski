//you can send as many data as you want in putExtra

     Intent intent = new Intent(D.this, A.class);
        intent.putExtra(A.TAG_ACTIVITY_FROM, "From_D");
    intent.putExtra(A.VALUE, 4);
        startActivity(intent);