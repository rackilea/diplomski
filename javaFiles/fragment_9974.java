public void printArray(String[] s){
    for (int i = 0; i < s.length; i++) {
        System.out.print("\"" + s[i] + "\",");
        for (int j = 0; j < s.length; j++) {
            if (j != i) {
                System.out.print("\"" + s[j] + "\",");
            }
        }
        System.out.println();
    }
}