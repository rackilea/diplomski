for (i = 0; i < 4; i++){
        for (j = 0; j < 4; j++){
            if (map[i][j] != 1 && map[i][j] != 0){
               b = false; // greedy approach can break or return here as well
                        System.out.println("--> A value of " + map[i][j] + " was found at " + i + "," + j);

                        }
                    }
               if (b == false){
                    System.out.println("Map does not have the correct format"); }
                else{
                System.out.println("The map is valid"); }