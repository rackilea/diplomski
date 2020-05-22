// declare these guys to keep track of where to draw
int maxI = 0; 
int maxJ = 0;

for (int i = 0; i < pts.length; i++){
    pts[i] = new Point2D(Math.random(), Math.random());
    StdDraw.setPenColor(StdDraw.RED);
    StdDraw.setPenRadius(0.008);
    pts[i].draw();
    for (int j = 0; j<i; j++){
        double distance[] = {pts[i].distanceTo(pts[j])};
        for (int k = 0; k <distance.length; k++ ){
            if (distance[k] > max){
                max = distance[k];
                maxI = i;
                maxJ = j;
            }
        }
    }
}

if (max > 0){
    System.out.println(max);
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.setPenRadius(0.002);
    pts[maxI].drawTo(pts[maxJ]);
}