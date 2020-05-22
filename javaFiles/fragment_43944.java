public static double calculateTuition(int hour, char major, char state) {
           int rate=0;
           int labfee=0;
           double statusfee=0;
           if (hour >= 12) {
               rate = 800;
         } else {
               rate = hour * 70;
           }
           if (major == 'C'||major == 'c') {
               labfee = 25;
         } else if (major == 'O'||major == 'o') {
               labfee = 35;
         } else if (major == 'X'||major == 'x') {
               labfee = 0;
           }
           if (state == 'Y'||state == 'y') {
               statusfee = 5;
         } else if (state == 'N'||state == 'n') {
               statusfee = 5+ rate*.2;      
           }
           double tuition = rate+labfee+statusfee;
           return tuition;
           }