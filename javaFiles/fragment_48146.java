ArrayList<String[]> data = new ArrayList<String[]>();
while(scanner.hasNext()){

   String[] text = scanner.nextLine().split(","); //assuming comma separated text in the line
   data.add(text);

}