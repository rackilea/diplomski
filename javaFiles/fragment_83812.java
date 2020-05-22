for(int i=0;i<n;i++){
    String temp="";
    for(int j=i;j<n;j++){
        temp+=S.charAt(j);
        // ^^ THIS IS NOT O(1)^^
    }
    System.out.println(temp);
}