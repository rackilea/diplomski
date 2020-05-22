int countTrees(int N,int h,int l) {
  if (N <=1) { 
    return(1); 
  } 
  else {     
    int sum=0;
    int left, right, root;
    for (root=1; root<=N; root++) { 
      left=0;right=0;
      if(l+1<=h)
      {
      left = countTrees(root - 1,h,l+1); 
      right = countTrees(N - root,h,l+1);      
      if(l==0)
       arr[root-1]+=left*right;
      sum+=left*right;
      }
    }     
    return sum;
  } 
}