public class Data {
private double[]fArray,aArray,vArray;
private double time;
private double[][]cArray;
public Data(double[] fArray, double[] aArray, double[] vArray, double[][] cArray,  double time) {
    System.out.println("This is my first parameterized constructor launched");
    // use this function System.arraycopy(source-array, source-index, dest-array, dest-index, lengthto-copy);
    //or simply copy 
    this.fArray=new double[fArray.length];
    for(int i=0;i<fArray.length;i++)
        this.fArray[i]=fArray[i];
    //and soon for other arrays
    System.out.println("This is my first output from costructor : " + fArray[0] + aArray[0] + vArray[0] + cArray[0][1] + time );
}


//getter method to get fArray when needed for calculation in Calc class
public double[] getFArray(){
    return fArray;
}