// To print the keys and values
     mapofmaps.forEach((K,V)->{                 // mapofmaps entries
         V.forEach((X,Y)->{                     // inner Hashmap enteries
             System.out.println(X+" "+Y);       // print key and value of inner Hashmap 
         });
     });