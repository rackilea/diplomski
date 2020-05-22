FileInputStream fileIn = new FileInputStream("shapeFile.txt");
 Scanner scan = new Scanner(fileIn);
 int[] var1 = new int[3];

 while(scan.hasNext()) {
     String shape = scan.next();
     if(shape.equals("Circle")) {
       for(int i = 0; i < 3;i++) {
          if(scan.hasNextInt()) {
            var1[i] = scan.nextInt();
          } else {
            break;
          }
       } 

       myShapes.addShape(new Circle(var1[0], var1[1], var1[2], Color.RED));
  }
}