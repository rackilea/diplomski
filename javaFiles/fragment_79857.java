import java.util.Random;

    //...

    Random r = new Random();

    String alphabet = "123xyz";
    for (int i = 0; i < 50; i++) {
        System.out.println(alphabet.charAt(r.nextInt(alphabet.length())));
    } // prints 50 random characters from alphabet