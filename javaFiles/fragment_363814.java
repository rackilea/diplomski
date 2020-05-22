public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  int size= Integer.valueOf(in.nextLine());
  String [] input= new String[size];
  System.out.println(input.length);
  for(int i=0;i<input.length;i++){
    input[i]=in.nextLine();
  }

  for(int i=0;i<input.length;i++) {
    System.out.print(input[i]);
  }
}