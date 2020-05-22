if(DataType.X.equals(transaction)){
    Intent i = new Intent (getBaseContext(), activity_X.class);
    startActivity(i);
} else {
    Intent i = new Intent (getBaseContext(), activity_Y.class);
    startActivity(i);
}