int[] numbers = new int[500];

for(int i=0; i<500; i++) {
   numbers[i] = i;
   System.out.println(numbers[i]);
}


int[] numbers2 = new int[500];

for(int i=500; i>0; i--) {
   numbers2[i-1] = i;
   System.out.println(numbers2[i-1]);
}