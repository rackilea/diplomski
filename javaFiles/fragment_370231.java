static List<Integer> alist; //is not in random method so it can be accessed by other methods
public static void Random ()
{
int Rand [] = new int [49];
for (int b = 0; b < 49; b++)
    Rand [b] = b;

alist = Arrays.stream(Rand)
                                    .boxed()
                                    .map (x -> x + 1)
                                    .collect (Collectors.toList());                                 

Collections.shuffle(alist);
}


private class HandleTextField implements ActionListener
{   
   @Override
   public void actionPerformed(ActionEvent event)
   {
       for (int a = 0; a < 49; a++)
       {
        if (event.getSource() == jbArray[a]) 
        {
            jbArray[a].setText(alist.get(a)+"");//uses only the element you want rather than all of the list
        }   
     }
   }
}