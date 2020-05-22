Boolean isDone = true;
Scanner scan = new Scanner(System.in);
File f = new File("my.txt");
FileWriter fr = new FileWriter(f);
BufferedWriter br  = new BufferedWriter(fr);

while (isDone) {

   if (!isDone) {

 br.write(new Scanner(System.in).nextLine());

 }


}