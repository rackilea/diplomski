public static void main(String[] args) {
        int[] a1 = new int[]{2,3,4};
        int[] a2 = new int[]{1,2,2,3,4,4,3,5,6,7};
        recursion(a1,a2, new String());
    }

    public static void recursion(int[] a1, int[] a2, String soFar){
        int toSearch = a1[0];
        for(int i=0;i<a2.length;i++){
            if(a2[i] == toSearch){
                if(a1.length>1) {
                    int[] a1b = new int[a1.length - 1];
                    for (int j = 1; j < a1.length; j++) {
                        a1b[j - 1] = a1[j];
                    }
                    recursion(a1b, a2, soFar+ "a2["+i+"]");
                }
                else {
                    System.out.println(soFar+ "a2["+i+"]");
                }
            }
        }
    }