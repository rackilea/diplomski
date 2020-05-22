//Writes player Name as an object to the output Stream
        System.out.println("Welcome, Enter your name :");
        try {
            Scanner playerInfo = new Scanner(System.in);
            playerName2 = playerInfo.nextLine();
            this.output.writeObject(playerName2);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } System.out.println("Welcome to The Game! " + playerName2);