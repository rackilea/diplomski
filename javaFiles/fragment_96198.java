File f = new File("d:\\cities.txt");
        Scanner input = new Scanner(f);
        Map<Integer,String> cityCode = new HashMap<Integer,String>();

        String text;
        while(input.hasNextLine())
        {
            text = input.nextLine();
            Scanner data = new Scanner(text);
            String name = data.next();
            int id2 = data.nextInt();
            cityCode.put(id2, name);
        }
        System.out.println("enter the postcode");    
        Scanner code = new Scanner(System.in);
        int id = code.nextInt();
        if(cityCode.containsKey(id)) {
            System.out.println(cityCode.get(id));
        } else {
            System.out.println("City Not found");
        }