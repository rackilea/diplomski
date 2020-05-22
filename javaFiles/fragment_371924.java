Intent intent = getIntent();
if (intent.hasExtra("exit")) {
    // User wants to exit
    finish();
} else if (intent.hasExtra("A2")) {
    // User wants to launch A2
    Intent a2Intent = new Intent(this, A2.class);
    startActivity(a2Intent);
} else {
    // Default behaviour is to launch A1
    Intent a1Intent = new Intent(this, A1.class);
    startActivity(a1Intent);
}