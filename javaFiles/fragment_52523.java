int total = 0;
int count = 0;
List<Integer> allScores = new ArrayList<Integer>();
while ((line = br.readLine()) != null) 
{
    String[] splitLine = line.split(txtSplitBy);
    String lastName = splitLine[0];  //first element of array
    String firstName = splitLine[1]; //second element of array
    String score = splitLine[2];     //third element of array

    System.out.println("Last Name: " + lastName 
                         + "\n" +"First Name: " + firstname + "\n" + 
                        "Test Score: " + score + "\n") ;

    int i = Integer.parseInt (score);
    total += i;
    count++;
    // Add to List
    allScores.add(i);
}
double average = total/count;