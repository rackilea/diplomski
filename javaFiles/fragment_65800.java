public int area() {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Enter width: ");
      width = scanner.nextInt();  
      System.out.print("Enter height: ");
      length = scanner.nextInt();
      return width * length;       
}