List<String> lines= new ArrayList<String>();
Scanner in = new Scanner(f); // f = input file
while(in.hasNextLine()) {
    lines.add(in.nextLine());
}
in.close();