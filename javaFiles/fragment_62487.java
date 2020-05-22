ArrayList<Integer> AllNum = new ArrayList<>();
        do
        {
            System.out.println ("Please enter a num");
            AllNum.add (sc.nextInt());
            System.out.println ("Do you want to enter a new sentence? Enter Y for yes and N for no");
            x = sc.nextLine();
        } while ("Y".equals(x));
        int Index = AllNum.get(AllNum.size() - 1); // change is here
        int [] AllNumArray = new int [Index];