if (isChecked) {
    Intent i = new Intent(MainActivity.this, ThirdActivity.class);
    startActivity(i);
} else {
    Intent i = new Intent(MainActivity.this, SecondActivity.class);
    startActivity(i);
}