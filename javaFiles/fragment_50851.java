int[][] drawPoints = new int[2][2];
int[][] drawPoints2 = new int[2][2];
drawPoints[0][0] = 1;
drawPoints[0][1] = 2;
drawPoints[1][0] = 3;
drawPoints[1][1] = 4;
drawPoints2[0][0] = 5;
drawPoints2[0][1] = 6;
drawPoints2[1][0] = 7;
drawPoints2[1][1] = 8;
ArrayList<Object> points=new ArrayList<Object>();
points.add(drawPoints);
points.add(drawPoints2);

for(Object tab : points){
    int[][] tmp = (int[][]) tab;
    for(int i=0;i < tmp.length;i++){ 
        for(int j=0;j<tmp[i].length;j++){ 
            System.out.println(tmp[i][j]);
        }
    }
    System.out.println("------------");
}