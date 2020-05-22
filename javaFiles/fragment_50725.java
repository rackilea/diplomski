String message = "Your password is [MASK:1234]!";

boolean bMasked = message.matches(".*\\[MASK:[^\\]]*\\].*");
String plainText = message.replaceAll("\\[MASK:([^\\]]*)\\]", "$1");
String withStars = message.replaceAll("\\[MASK:[^\\]]*\\]", "******");

System.out.println("bMasked: " + bMasked);
System.out.println("plainText: " + plainText);
System.out.println("withStars:  " + withStars);