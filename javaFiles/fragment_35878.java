private static List<String> rotations(String str) {
    int n = str.length();
    char temp;
    String temp1 = null;

    List<String> retval = new ArrayList<String>();

    for(int i=0; i<n; i++){
        StringBuilder sb = new StringBuilder();
        for(int j=i+1; j<n; j++)
            sb.append(str.charAt(j));
        for(int k=0; k<=i; k++)
            sb.append(str.charAt(k));
        retval.add(sb.toString());
   }
   return retval;
}