public class test
{
    static List<String> list = new ArrayList<>();
    static List<String> listSentence = new ArrayList<>();
    static Random rand = new Random();

    public static void main (String []args)
    {
      list.add("hi1");
      list.add("hi2");
      list.add("hi3");
      list.add("hi4");
      listSentence.add("bye1");
      listSentence.add("bye2");
      listSentence.add("bye3");
      listSentence.add("bye4");

      for (int i=0; i<4; i++)
        showRandomQuestionCat2();
    }

     private static void showRandomQuestionCat2() 
     {

      int n = rand.nextInt(100);
      if (n < 70) {
        int index = rand.nextInt(list.size());
        String randomString = list.get(index);
        System.out.println(list.get(index));
        list.remove(index);

      } else {
        int index2 = rand.nextInt(listSentence.size());
        String randomString = listSentence.get(index2);
        System.out.println(listSentence.get(index2));
        listSentence.remove(index2);
      }
    }
}