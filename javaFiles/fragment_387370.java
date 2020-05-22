class V2Radiator {
 static int size=0;

 V2Radiator(ArrayList list) {
     for (int x = 0; x<5; x++) {
        list.add(new SimUnit("V2Radiator"));
        size++;
     }    
  }
}

class V3Radiator extends V2Radiator {
 V3Radiator(ArrayList lglist) {
    super(lglist); //here size variable will be incremented for all instances.
    for(int g=0; g<10; g++) {
        lglist.add(new SimUnit("V3Radiator"));
    }
  }   
}