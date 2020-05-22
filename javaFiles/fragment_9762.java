Scanner scan = new Scanner(System.in);

        boolean bidding;
        int startbid;
        int bid;

        bidding = true;

        System.out.print("Alright folks, who wants this unit?" +
                "\nHow much. How much. How much money where?" );
        try
        {
            startbid = Integer.parseInt(scan.nextLine());

            while(bidding)
            {
                System.out.println("$" + startbid + "! Whose going to bid higher?");
                startbid =+ Integer.parseInt(scan.nextLine());
            }
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Please enter a bid");
        }