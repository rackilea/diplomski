import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class WordGeneratorClass
{
   private static final String filepath="../assets/words.txt";
   public String randomWord;
   public Random rand;
   private ArrayList<String> words=new ArrayList<String>();

   public void WordGenerator()
   {
        rand=new Random();
        String line;

        try
        {
           BufferedReader br = new BufferedReader(new FileReader(filepath));

           if(!br.ready())
           {
            System.out.println("No File");
           }
           else while((line=br.readLine())!=null)
           {
              words.add(line);
           }
           br.close();
        }
        catch (IOException e)
        {
           e.printStackTrace();
        }

        int size=words.size();
        Random rn=new Random();
        int randWord=rn.nextInt(size);

        randomWord=words.get(randWord);

        System.out.println(randomWord);
   }

   public static void main(String args[])
   {
      WordGeneratorClass gen = new WordGeneratorClass();
      gen.WordGenerator();
   }
}