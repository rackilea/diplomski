properties:
my.message=You have earned {0} badges out of {0}

Java:
String pattern = bundle.getString("my.message");
String message = MessageFormat.format(pattern, 15, 39); // You have earned 15 badges out of 39