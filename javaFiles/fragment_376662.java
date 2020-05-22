Integer[] array = {12, 23, -22, 0, 43, 545, -4, -55, 43, 12, 0, -999, -87, 12};

     List<Integer> pos1 = new ArrayList<>();
     List<Integer> neg1 = new ArrayList<>();

     for (int i : array) {
         if (i > 0) {
             pos1.add(i);
         } else if(i < 0){
             neg1.add(i);
         }
     }

     System.out.print("Ukupno: ");
     for (int i : array) {
         System.out.print(" " + i);
     }

     System.out.print("\nPozitivni: ");
     for (int i : pos1) {
         System.out.print(" " + i);
     }

     System.out.print("\nNegativni: ");
     for (int i : neg1) {
         System.out.print(" " + i);
     }