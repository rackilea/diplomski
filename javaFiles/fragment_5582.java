public Bitmap barrel (Bitmap input, float k){
    if(input!=null){
       Log.e(TAG, "*********** bitmap input = "+input.toString());
    }
    int []arr = new int[input.getWidth()*input.getHeight()];
      // replace the j, i for loops:
    int jMax = input.getHeight();
    int jMid = jMax / 2;
    int iMax = input.getWidth();
    int iMid = iMax / 2;
    int nrOfProcessors = Runtime.getRuntime().availableProcessors();
    Log.e(TAG, "*********** NUM OF PROCESSORS = " + nrOfProcessors);

    PartialProcessing part1 = new PartialProcessing(0, jMid - 1, input, k); 
    PartialProcessing part2 = new PartialProcessing(jMid, jMax - 1,input, k); 
    Log.e(TAG, "*********** about to call task1.call()");
    try{
       PartialResult result1 = part1.call();// blocks until the thread returns the result
       Log.e(TAG, "*********** just called part1.call()");
       result1.fill(arr);
       Log.e(TAG, "*********** result1 arr length = " + arr.length);

       Log.e(TAG, "*********** about to call part2.()");
       PartialResult result2 = part2.call(); // blocks until the thread returns the result
       Log.e(TAG, "*********** just called part2.call()");
       result2.fill(arr);
       Log.e(TAG, "*********** result2 arr length = " + arr.length);
    }catch(Exception e){
        e.printStackTrace();
    }
    Bitmap dst2 = Bitmap.createBitmap(arr,input.getWidth(),input.getHeight(),input.getConfig());
    if(dst2!=null)
        Log.e(TAG, "*********** dst2 is not null" );
    return dst2;
}