void findCart(int arr1[],int arr2[], int n, int n1) 
{       
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n1; j++) 
        sb.append("{" + arr1[i] + ", " + arr2[j]+"}, "); 
    }
    jLabel1.setText(sb.toString());
}