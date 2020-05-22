public String remdups(String input) {
  StringBuilder response = new StringBuilder(input.length());
  char temp;

  for (int i = 0; i < input.length(); i++) {
     char next = input.charAt(i);
     if (temp != next) {
       temp = next;
       response.append(temp);
     }
  }

  return response.toString();
}