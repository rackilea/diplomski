try (FileWriter file = new FileWriter("hello.txt")) {
  String sb = " ";
  for (int i = 0; i < 1; i++) {  // Note: added a i++
    sb += alphabet.charAt(r.nextInt(N));
    System.out.println(sb);
    int length = sb.length();
    file.write(sb);
    // file.close();   <---- NOPE: don't do this
    if (length == 30) {
      sb = " ";
    }
  }
}