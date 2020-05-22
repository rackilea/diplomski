Intent intent = new Intent(this, activity.class);

if (some_variable  == 1) {
    intent.putExtra("1", match(stringRepresentation, patterns[0]));
    intent.putExtra("2", match(stringRepresentation, patterns[1]));
    //and other 507 variants
} else if (some_variable == 2) {
    intent.putExtra("3", match(stringRepresentation, patterns[0]));
    intent.putExtra("4", match(stringRepresentation, patterns[1]));
    //and other 507 variants
}

startActivity(intent);