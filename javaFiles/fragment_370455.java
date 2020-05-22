{
    public static void main(String[] args)
    {
        String text = ";\tone;\ttwo;\tthree;\tfour";

        for (String word: text.split("; "))
//      for (String word: text.split(";\t"))
            System.out.println(word);
    }
}