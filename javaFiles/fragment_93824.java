int[][] MyMat = {{0,1,2,3,4}, {9,8,7,6,5}};

// get your columns... (easy)
int[] My0= MyMat[0]; //My0 = {0,1,2,3,4}
int[] My1= MyMat[1]; //My1 = {9,8,7,6,5}

// get the rows... (manually)
int[] My_0= new int[]{MyMat[0][0],MyMat[1][0]}; //My_0 = {0,9}
int[] My_1= new int[]{MyMat[0][1],MyMat[1][1]}; //My_1 = {1,8}
int[] My_2= new int[]{MyMat[0][2],MyMat[1][2]}; //My_2 = {2,7}
int[] My_3= new int[]{MyMat[0][3],MyMat[1][3]}; //My_3 = {3,6}
int[] My_4= new int[]{MyMat[0][4],MyMat[1][4]}; //My_4 = {4,5}

// get the rows... (as a for-loop)
int size = MyMat.length;
int[] My_0 = new int[size]; //My_0 = {0,9}
int[] My_1 = new int[size]; //My_1 = {1,8}
int[] My_2 = new int[size]; //My_2 = {2,7}
int[] My_3 = new int[size]; //My_3 = {3,6}
int[] My_4 = new int[size]; //My_4 = {4,5}
for (int i=0;i<size;i++){
    My_0[i] = MyMat[i][0];
    My_1[i] = MyMat[i][1];
    My_2[i] = MyMat[i][2];
    My_3[i] = MyMat[i][3];
    My_4[i] = MyMat[i][4];
}