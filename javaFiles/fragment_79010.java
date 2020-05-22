Set<String> consonants = new HashSet<>();
consonants.add("a");
consonants.add("e");
consonants.add("i");
consonants.add("o");
consonants.add("u");

while (sc.hasNextLine()) {

          readLine = new Scanner(sc.nextLine());
          x = readLine.nextLine();
          numberOfLines++;  

          if(consonants.contains(x.toLowerCase())) { 
              consonants++;
          }
}