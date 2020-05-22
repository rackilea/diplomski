public static void main(String[] args)  throws FileNotFoundException {
       String routeName = "";
       Scanner timetable;
       int count = 0;
       String[] s = new String[10];
       timetable = new Scanner(new File("fileName.txt"));
       while (timetable.hasNextLine()) {
             String line = timetable.nextLine();
             s[count++] = line;
       }
       routeName = s[0];
       System.out.println(routeName);
}