try{
        Scanner scanner=new Scanner("demo.txt");
        List<String> list=new ArrayList<>();

        while(scanner.hasNextLine()){
            list.add(scanner.nextLine()); 
        }

        boolean has = false;
        for (String str : list) {
            if (str.contains("Boys")) {
                has = true;
                break;
            }
        }
        if (has) {
            System.out.print("found");
        } else {
            System.out.print("Not found");
        }
    }
    catch(Exception e)
    {
        System.out.print(e);
    }