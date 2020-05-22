char[]aa={'A','C','D','E','F','G','H','I','K','L','M','N','P','Q','R','S','T','V','W','Y','U','O','B','J','Z','X'};

String s = "aStrinG";

for (char c : s.toCharArray()) {
    for (char c2 : aa) {
       if (c2 == c) {
          System.out.println("String char " + c + " exists in char array");
       }
    }
}