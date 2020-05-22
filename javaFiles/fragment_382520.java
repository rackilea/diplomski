// This will create an "ID" of 10 char.
String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
StringBuilder sb = new StringBuilder(10);
for (int i = 0; i < 10; i++) {
        int index  = (int) (alphabet.length() * Math.random());
        sb.append(alphabet.charAt(index));
}

//printing sb.toString() will print something like: q3x3LcAK39