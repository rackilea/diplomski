int[] tmpArray = tmpArrayThreadLocal.get();
if( tmpArray == null ){
   tmpArray = new int[100];
   tmpArrayThreadLocal.set(tmpArray);
}
method(tmpArray, 5)