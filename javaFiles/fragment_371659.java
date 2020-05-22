Object[][] obj = new Object[1][1];
obj[0][0] = new int[]{0,1,0,2};
System.out.println(obj);
//To get int[]
int[] arr= (int[]) obj[0][0];//Need to cast to the int[] specifically
//because it's currently stored as an Object
System.out.println(Arrays.toString(arr));