// File being read....
StringBuilder a = new StringBuilder();

while ((currentString = s.next()) != null) {
    reverse(a, currentString);
}

// ...

public static void reverse(StringBuilder a, String currentString) {
    a.insert(0, s);
    a.insert(0," ");
}