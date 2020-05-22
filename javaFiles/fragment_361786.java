String statement = "SELECT * FROM flats";
if (priceField.getText() != null) {
    statement = statement.concat("WHERE Rent BETWEEN ").concat(priceField.getText()).concat(" AND");
} else {
    statement = statement.concat("WHERE Rent BETWEEN 0 AND");
}
...
and so on