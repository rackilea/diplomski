for(int c= 0; c<box.length;c++){
         for(int r= 0; r<box.length;r++){
             box[c][r] = new TextField("x");
             //System.out.println(box[c][r]);

                 if (nOdd == true){

                     box[c][r].setStyle("-fx-background-color: white;" + "-fx-border-color: black;");

                     //switch for next iteration
                     System.out.println(nOdd + " - inside if true before ");
                     nOdd = false;
                     System.out.println(nOdd + " - inside if true after");
                 }else if (nOdd == false){
                     box[c][r].setStyle("-fx-background-color: black;" + "-fx-border-color: black;");

                    //switch for next iteration
                     System.out.println(nOdd + " + inside if false before");
                     nOdd = true;
                     System.out.println(nOdd + " + inside if false after");
                    }

             gridpane.add(box[c][r], c, r);

         }//inner
         if(n % 2 == 0) {
             nOdd = nOdd ^ true;
         }
     }//outer