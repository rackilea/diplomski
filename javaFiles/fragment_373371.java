Bottle[] bottles = new Bottle[3];
   int counter = 0;

   //foreach
   for (Bottle bottle : bottles) {
        bottles[counter] = new Bottle();
        System.out.println(bottles[counter].waterAmount);
        counter++;
   }