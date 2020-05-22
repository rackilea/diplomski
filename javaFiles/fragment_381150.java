String[] array = {"7", "first", "3", "second", "2", "third", "4", "fourth", "2", "fifth"};
for (int i=0; i < array.length; i+=2)
{
   int count = Integer.parseInt(array[i]);
   for (int j=0; j < count; j++) {
       System.out.print(array[i+1]);
   }
   System.out.println();
}