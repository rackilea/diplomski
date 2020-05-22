static int counter = 0;

public static int getNextQuestion(ArrayList<Integer> list)
{
 if(counter == list.size() + 1) return -1;
 return list.get(counter++);
}