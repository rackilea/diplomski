int N = in.nextInt();
String [][] defibDetails = new String[N][];
in.nextLine();
for (int i = 0; i < N; i++) {
    String DEFIB = in.nextLine();
    String [] details = DEFIB.split(";");
    defibDetails[i]=details; // <<<<<<<<
}
System.out.println(defibDetails[0][0]);