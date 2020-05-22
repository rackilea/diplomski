for (int threeD = 0; threeD < map[0].length; threeD++){
    for(int twoD = 0; twoD < map.length; twoD++){
        for (int oneD = 0; oneD < map[twoD][threeD].length; oneD++){

                      System.out.print(map[twoD][threeD][oneD]);
             }
       System.out.print(" ");
    }
    System.out.println();
}