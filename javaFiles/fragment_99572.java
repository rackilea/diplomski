Scanner sc = new Scanner(fileEntry);
while (sc.hasNextLine()) {
    String s = sc.nextLine();
    if(s.contains("@")) {
        System.out.println(s);
        pTD.println(s);
    }
}
sc.close();
pTD.close();