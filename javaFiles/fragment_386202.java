for(int x = 0;x<marks.size();x++)
{
    Collections.sort(marksSorted);
    classmarksField.setText(marksSorted.get(x)+"\n");
    System.out.println(marksSorted);//testing purposes
}