StringBuilder teamName=new StringBuilder();
for (int i = 0; i < countOfTokens-1; i++)
{
  if (i>0) teamName.append(' ');
  teamName.append(sort.nextToken());          
}
teamNames[k]=teamName.toString(); //add the new team to your teamNames array
points[k]=Integer.parseInt(sort.nextToken()); //if your points array is of int type