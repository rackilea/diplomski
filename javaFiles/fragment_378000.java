Pattern p = Pattern.compile("</[^>]+>");
Scanner s = new Scanner(new BufferedReader(new FileReader("input.txt")));

for (int lineNum=1; s.hasNext(); lineNum++) {
      Matcher m = p.matcher(s.next());
            if(m.find()){
              System.out.println(lineNum);
            }

}