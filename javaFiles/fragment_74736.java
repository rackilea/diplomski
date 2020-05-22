ArrayList<String> lines = new ArrayList<>();

        for(int i=0;i<=3;i++)
            lines.add(sc.nextLine());

        for(int i=0;i<=3;i++)
        {
            String Temp[] = lines.get(i).split(" ");

            switch (Temp[1]) {
                case "PHP":
                    conversion = Double.parseDouble(Temp[0])*51.23;
                    System.out.println(Temp[1]);
                    System.out.println("$"+Temp[0]+" CONVERTS TO "+df.format(conversion)+" PHP.");
                    break;
                // Other cases
                // ...
                // ...
                default:
                    continue;
                    //i--;
                    //System.out.println("Invalid input, Please try again");
            }