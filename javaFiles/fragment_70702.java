public static double getSecondMaxValue(double n1, double n2, double n3, double n4,double n5, double n6, double n7, double n8, double n9, double n10){

    double maxValue = max10(double n1, double n2, double n3, double n4,double n5, double n6, double n7, double n8, double n9, double n10)

    double secondMaxValue = 0.0;

    if(maxValue == n1)
        secondMaxValue = max9(double n2, double n3, double n4,double n5, double n6, double n7, double n8, double n9, double n10);
    else if (maxValue == n2)
        secondMaxValue = max9(double n1, double n3, double n4,double n5, double n6, double n7, double n8, double n9, double n10);
    else if (maxValue == n3)
         secondMaxValue = max9(double n1, double n2, double n4,double n5, double n6, double n7, double n8, double n9, double n10);
    ...
    ...
    else if (maxValue == n10)
         secondMaxValue = max9(double n1, double n2, double n3, double n4,double n5, double n6, double n7, double n8, double n9);

    return secondMaxValue;

}


public static double max9(double n1, double n2, double n3, double n4,double n5, double n6, double n7, double n8, double n9) {

    double r1,r2,r3,r4,r5,r6,r7,r8,r9;

    r1= max2(n1,n2);
    r2= max2(n3,n4);
    r3= max2(n5,n6);
    r4= max2(n7,n8);
    r5= n9;

    r6= max2(r1, r2);
    r7= max2(r3, r4);

    r8= max2(r6, r7);
    r9= max2( r8, r5 );

    return max2( r9, r5 );
}