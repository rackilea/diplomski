int[] array1 = new int[5];
array1[0] = 3;
array1[1] = 7;
array1[2] = 10;
array1[3] = 6;
array1[4] = 4;

int count = 0;
for(int i =0;i<array1.length;i++){

    for(int j=i+1;j<array1.length;j++){

       if(array1[i]> array1[j] ){
          count++;
       }

    }
 }
 System.out.println(count);