MyString[] input1Array = mySplit(input1);

List<MyString> stringList1 = new ArrayList<MyString>(Arrays.asList(input1Array));           
List<MyClass> input1List = new ArrayList<MyClass>(stringList1); 

class MyString{
    private String myString;
    public MyString(String input)
    {
    }
}

class MyClass extends MyString{
    public MyClass()
    {
    }
}

public MyString[] mySplit(String inputString)
{
      ArrayList<MyString> eachMyString = new ArrayList<MyString>();
      //loop through each char in inputString and add each to eachMyString   ArrayList
      return eachMyString.toArray();
}