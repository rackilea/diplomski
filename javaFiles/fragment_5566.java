public static void main(String[] args) throws FileNotFoundException
{
    Scanner s = new Scanner(new FileReader("C:/Users/Sean/workspace/Imbored/bin/113809of.fic"));
    while(true)
    {
        words.clear();
        String letters = enterLetters();
        words.addAll(Words(letters));
        while(s.hasNextLine()) {
             String line = s.nextLine();
             String finalword = checkWords(line, words);
             if (finalword != null) finalwordset.add(finalword);
        }
        s.reset();
        System.out.println(finalwordset);
        System.out.println();
        System.out.println("_________________________________________________________________________");
    }
}