public void getArray(double array1[]) {

    array1 = new double[12];
    this.maxValues = array1;

    for(int i=0;i<array1.length;i++)
    {
        Log.i("sanket",maxValues[i]+"");
    }
}