int val = 1000000;

for (int i = 0; i < 100; i++) {
     val = val * val;
     if (val < 0) {
         System.out.println(val);
     }
}