int indexA=0;
 int indexB=0;
 int[] result = new int[1+A.length>B.length?A.length:B.length];
 int indexResult=result.length-1;

 while(indexA < A.length && indexB <B.length){//inside is same idea
    tmp = A[indexA++] + B[indexB++] + carry;
    //... do here as for stacks for tmp and carry
    result[indexResult--];
 }

 while(indexA < A.length){
    //do as in stack version
 }

  while(indexB < B.length){
    //do as in stack version
 }