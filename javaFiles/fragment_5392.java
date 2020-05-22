//check if both the maps contain the "bryan"
if(hmap.containsValue("bryan") && hmap2.containsValue("bryan")) {

     //iterate over the hmap2 using the keys
     for(String key : hmap2.keySet()) {

          //if the value is bryan, then get the key, which is the salary
          if(hmap2.get(key) != null && hmap2.get(key).equals("bryan")) {
              System.out.println(key);
          }
     }
 }