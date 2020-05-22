String colors[][][][][][] = new String[4][4][4][4][4][4];

    for(String[][][][][] layer1 : colors){ // Iterates over all 5D arrays in colors
        for (String[][][][] layer2 : layer1){ //Iterates over all 4D arrays in the 5D arrays
            for (String[][][] layer3 : layer2){ // 3D
                for (String[][] layer4 : layer3){ // 2D
                    for (String[] actualArray : layer4){ //actual string arrays
                        Arrays.fill(actualArray, "something"); 
                    }
                }
            }
        }
    }