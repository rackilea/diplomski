int[][] MyMat = {{0,9},{1,8},{2,7},{3,6},{4,5}};

// get the rows... (easy)
int[] My_0= MyMat[0]; //My_0 = {0,9}
int[] My_1= MyMat[1]; //My_1 = {1,8}
int[] My_2= MyMat[2]; //My_2 = {2,7}
int[] My_3= MyMat[3]; //My_3 = {3,6}
int[] My_4= MyMat[4]; //My_4 = {4,5}

// get the columns... (manually)
int[] My0= new int[]{MyMat[0][0],MyMat[1][0],MyMat[2][0],MyMat[3][0],MyMat[4][0]}; //My0 = {0,1,2,3,4}
int[] My1= new int[]{MyMat[0][1],MyMat[1][1],MyMat[2][1],MyMat[3][1],MyMat[4][1]}; //My1 = {9,8,7,6,5}

// get the columns... (as a for-loop)
int size = MyMat.length;
int[] My0 = new int[size]; //My0 = {0,1,2,3,4}
int[] My1 = new int[size]; //My1 = {9,8,7,6,5}
for (int i=0;i<size;i++){
    My0[i] = MyMat[0][i];
    My1[i] = MyMat[1][i];
}