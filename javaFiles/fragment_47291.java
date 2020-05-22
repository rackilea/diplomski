Scanner s = new Scanner(new File("text"));
    Pattern p = Pattern.compile("^(\\d+) (\\d+) (\\d+)$", Pattern.MULTILINE);
    while(s.hasNextLine()){
        if(s.findInLine(p)!=null){
                            //just printing the result. you can do needful here.
            MatchResult result = s.match();
            System.out.println("full line:" + result.group(0));
            System.out.println("individuals");
            for (int i=1; i<=result.groupCount(); i++)
                 System.out.println(result.group(i));

        }

        s.nextLine();
    }