String[] names = {"Blinky","Inky","Pinky","Clyde"};
    int[] scores = {42,37,67,50};

    List<NameScoreEntity> data = new ArrayList<>(); // your data is now stored here

    for (int i= 0; i < scores.length; i++){
        data.add(new NameScoreEntity(names[i], scores[i]));
    }
    //print unsorted
    System.out.println("Unsorted\n---------");
    for (NameScoreEntity e : data) {
        System.out.println(e);
    }