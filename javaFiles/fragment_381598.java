//Given the max value of the graph maxInt
for (int i=maxInt;i>0;i--) {
    for (int j=0;j<count.length;j++) {
        if (count[j]>=i) {
            System.out.print(" * ");
        } else {
            System.out.print("   ");
        }
    }
    System.out.println("NEWLINE");
}