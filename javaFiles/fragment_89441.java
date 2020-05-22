try{
    Scanner scan = new Scanner(new File(folder + "file.txt"));
    data=scan.nextLine();
    scan.close();

}
finally
{ 
      System.out.println("Finally ");
}