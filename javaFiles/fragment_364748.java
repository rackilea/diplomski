for (int i = 1; i < myPoints.size(); i++) {

    tempFirst = myPoints.get(i-1).x;
    tempSecond = myPoints.get((i)).x ;
    tempYFirst = myPoints.get(i-1).y;
    tempYSecond = myPoints.get((i)).y;

    xValue = tempFirst - tempSecond;
    yValue = tempYFirst - tempYSecond;

    tempX2 = Math.pow(xValue, 2);
    tempY2 = Math.pow(yValue, 2);

    distance += Math.sqrt((tempX2 + tempY2));

    System.out.println(tempSecond);
 }