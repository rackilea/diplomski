String input = "   JP++ HELLO WORLD START \n hello \n world\n JP++ END";
    Scanner sc = new Scanner(input);

    if(sc.findInLine("JP++") == null || sc.findInLine("START") == null){
        throw new RuntimeException("Program has to start with 'JP++ _NAME_ START' ");
    }
    sc.nextLine();
    while(sc.hasNext()){
            if (sc.findInLine(Pattern.compile("JP......")) != "JP++ END" )  {
                Scanner r = sc;
                if(!r.hasNextLine() || r.findInLine(Pattern.compile(".")) == null){
                    return;
                }
                System.out.println(sc.nextLine());
            }
    }