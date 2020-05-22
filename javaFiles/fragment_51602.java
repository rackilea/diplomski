class Main
{  
public static void main(String args[])
{
    String date = "",neawe = "";
    String myNum = "314562173583721321376";
    String inputArray[] = new String[] {"3" ,"314","49", "90234","56217358", "14","3721","376","4"," 789" };
ArrayList<String> newArrayWithOnlyTheContainedNums = new ArrayList<>();

for (int i =0 ;i< inputArray.length - 1 ;i++ ){

    if(myNum.contains(inputArray[i])  && inputArray[i].length() >= 3){

        newArrayWithOnlyTheContainedNums.add(inputArray[i]);
    }
}



for (int i =0 ;i< newArrayWithOnlyTheContainedNums.size() ;i++ ){
  date = String.join(" ",newArrayWithOnlyTheContainedNums); 
}

System.out.println("date is = "+ date);


    }
}