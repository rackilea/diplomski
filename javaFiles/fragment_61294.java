char[] copyFrom={'s','n','a','d','g'};
    char[] copyto=new char[7]; // copyto = {'','','','','','',''}
    System.arraycopy(copyFrom, 1, copyto, 0, 3); // copyto = {'n','a','d','','','',''}
    System.out.println(new String (copyto));
    System.arraycopy(copyFrom, 1, copyto, 1, 3); // copyto = {'n','n','a','d','','',''}, 
// because first element 'n' stay from previous step

   System.out.println(new String (copyto));  
   System.arraycopy(copyFrom, 1, copyto, 2, 3); // from previous step you have {'n', 'n'} and replace only 2, 3 and 4 elements

//  {'n','n','n','a','d','',''}, 
    System.out.println(new String (copyto));
    System.arraycopy(copyFrom, 1, copyto, 4, 3); // from previous step you have {'n', 'n', 'n'} and replace only 4, 5 and 6 elements
    System.out.println(new String (copyto));
}