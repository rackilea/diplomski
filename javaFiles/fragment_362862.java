public static int[] getProductsExcludingCurrentIndex( int[] arr ) {
     if ( arr == null || arr.length == 0 ) return new int[]{};
     int[] leftProduct = new int[arr.length];
     int runningProduct = 1;
     //Compute left product at each i
     for ( int i = 0; i < arr.length; i++ ) {
       leftProduct[i] = runningProduct;
       runningProduct = runningProduct*arr[i];
    }
    runningProduct = 1;
    //By reverse traversal, we compute right product but at the same time update the left 
    //product, so it will have leftProduct*rightProduct
    for ( int i = arr.length - 1; i >= 0; i-- ) {
        leftProduct[i] = leftProduct[i]*runningProduct;
        runningProduct = runningProduct*arr[i];
    }
    return leftProduct;
}