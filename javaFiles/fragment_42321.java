static final String chars = 
               "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
               "abcdefghijklmnopqrstuvwxyz" +
               "0123456789`~!@#$%^&*()-_" +
               "=+;:'|\"<,>./?";

static final Random rand = new Random();
public static String randString(int length) {
     char[] gen = new char[length];
     for (int i = 0; i < length; i++) 
          gen[i] = chars.charAt(rand.nextInt(chars.length));
     return new String(gen);
}