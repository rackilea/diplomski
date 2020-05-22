public static void main(String[] args) {
    String[] greetings = {"well", "good", "great", "awesome", "fabulous"};
    String[] bad_greetings = {"bad", "awful"};
    String[] responses = {"you", "yourself"};

    System.out.println("Hello there, how are you?");
    String response;
    Scanner scan = new Scanner(System.in);
    response = scan.nextLine();
    for (String greeting : greetings) {
        if (response.contains(greeting)) {
            System.out.println("Well, good for you!");
            break;//return;
        }
    }
    for (String b_greet : bad_greetings) {
        if (response.contains(b_greet)) {
            System.out.println("At least you have me.");
            break;//return;
        }
    }
    for (String reply : responses) {
        if (response.contains(reply)) {
            System.out.println("I'm well, thank you.");
            break;//return;
            // } else {
            // System.out.println("Let's move on then.");
            // }

        }
    }
}