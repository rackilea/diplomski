System.out.println("File contents:");
while (in.hasNextLine()) {
    System.out.println(in.nextLine());
}
in = new Scanner(new FileReader(dir + "/input5.txt"));
//now you can do your counting, as the buffer has been reset