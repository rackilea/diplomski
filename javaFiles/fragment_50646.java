public static void main(String[] args) {
     String input = " For example, 134567H;Gabriel;24/12/1994;67;78;89";
     Scanner scanner = new Scanner(input);
     scanner.useDelimiter(";");
     String firstPart = null;
     while(scanner.hasNext()){
         firstPart = scanner.next();
         break;
     }

     String secondPart = input.split(firstPart)[1].substring(1);
     System.out.println(firstPart);
     System.out.println(secondPart);
     scanner.close();
}