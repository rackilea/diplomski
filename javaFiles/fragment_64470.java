public String getChoice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose rock, paper or scissors:");
        String player = scan.next();

        while ((!player.equalsIgnoreCase("rock"))
                && !player.equalsIgnoreCase("paper")
                && !player.equalsIgnoreCase("scissors")) {
            System.out.println("Sorry, that is'nt a choice. Choose rock, paper or scissors!");
            System.out.println("Choose rock, paper or scissors:");
            player = scan.next();
        }

        System.out.println("Good choice!");
        System.out.println("You chose " + player);
        return "";
    }