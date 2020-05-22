int jay[] = {1,2,3,4,5,6};
int jay2[] = Arrays.copyOf(jay,jay.length);
System.out.println("Original\tAfter");
multiplyByTen(jay2);
for (int i = 0; i < jay.length; i++) {
    System.out.println(jay[i]+"\t\t"+jay2[i]);
}