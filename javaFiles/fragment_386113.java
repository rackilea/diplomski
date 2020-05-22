final String SPLIT = "-> int ";

    List<String> lines = Files.readAllLines(Paths.get("C:\\test.txt"), StandardCharsets.UTF_8);

    int x = 0,y = 0;

    int temp;

    for(int i=0; i<lines.size(); i++){

        temp = Integer.parseInt(lines.get(i).split(SPLIT)[0].trim());
        // in case id line contains integer only:
        // temp = Integer.parseInt(lines.get(i).trim());

        if(i % 2 == 0){
            x += temp;
        }
        else{
            y += temp;
        }
    }

    System.out.println(x);
    System.out.println(y);