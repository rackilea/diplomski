ArrayList<String> list = new ArrayList();
while (scan.hasNext()) {
  String s = scan.nextLine();
  list.add(s);
}

int [][] myArray = new int[list.size()][3];

for(int i = 0; i < myArray.length; ++i)
{
 String[] tokens = list.get(i).split("\\s+");//extra spaces
 for(int j = 0; j < tokens.length; ++j)
 {
   myArray[i][j] = Integer.parseInt(tokens[j]);
 } 
}