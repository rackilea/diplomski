String input = "118u121u23n24";
    String[] s2;
    ArrayList<String> main = new ArrayList<String>();

    String[] split = input.split("u");
    for(int x=0; split.length>x; x++){
        s2 = split[x].split("n");

        for(int k=0; k<s2.length; k++){
            main.add(s2[k]);
            if(s2.length>k+1)
                main.add("n");
        }

        if(split.length>x+1)
            main.add("+");
    }
    // print main array to test
    for(int i=0;i<main.size();i++)
        System.out.println(main.get(i));