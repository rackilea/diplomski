String colour1 = "#FFFFFF";
     String colour2 = "#000000";

     StringBuilder result = new StringBuilder("#");
     for (int i=0;i<3;i++) {
         String h1 = colour1.substring(i*2+1, 3+(i*2));
         String h2 = colour2.substring(i*2+1, 3+(i*2));

         long l1 = Long.parseLong(h1, 16);
         long l2 = Long.parseLong(h2, 16);

         long mid = (l1 + l2) / 2; //truncating not rounding

         String midStr = Long.toString(mid, 16);
         if (midStr.length() == 1) {
             result.append("0");
         }
         result.append(midStr.toUpperCase());

     }