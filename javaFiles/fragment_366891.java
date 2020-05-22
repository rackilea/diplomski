int[][] matrixOne= {{1,2,3,4},{10,20}};

int [] sumUp=new int[matrixOne.length];

for(int i=0;i<matrixOne.length;i++) {
  sumUp[i] = Arrays.stream(matrixOne[i]).sum();
}