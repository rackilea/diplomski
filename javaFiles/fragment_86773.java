double total = 0;
            for (int i = 0 + x; i < 5 + x; i++) {
                for (int j = 0 + y; j < 5 + y; j++){
                    total += store.image[i][j];
                    //System.out.println("Normal store values " + store.image[i][j]);
                }
            }
            double average = total / 25;