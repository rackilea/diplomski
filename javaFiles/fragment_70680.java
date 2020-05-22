Random r = new Random();

String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
StringBuilder result = new StringBuilder();
final int lengthOfDesiredString = 25;
for (int i = 0; i < lengthOfDesiredString; i++) 
    result.append(alphabet.charAt(r.nextInt(alphabet.length())));

System.out.println(result);