try (Scanner sc = new Scanner(new File("Students.txt"))) {
    while (sc.hasNextLine()) {
      String name = sc.readLine();
      int age = Integer.parseInt(sc.readLine());
      double gpa = Double.parseDouble(sc.readLine());
      /* Create A New Student Object & Add To List */
      add(new Student(name, age, gpa));
    }
} catch (FileNotFoundException e) {
    System.out.println("Error");
}