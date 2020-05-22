for (int n = 0; n < data.get(0).size(); n++) {  //Loop for whole table
           if (data.get(1).get(n) > 0){  // row with condition when to enter second loop
               int n0=n;
               for (; n < data.get(0).size(); n++){ //second loop
                 if (data.get(0).get(n) > data.get(0).get(n0) + 10 ){ // breaks second loop
              //somecode
                 break;
                 }
              }
           }
        }