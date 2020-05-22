Scanner scanner = new Scanner(file);
   double arr = new double[scanner.nextInt()];

   for(int i = 0; scanner.hasNextDouble(); i++) {
       arr[i] = scanner.nextDouble();
   }
   scanner.close();