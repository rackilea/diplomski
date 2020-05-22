public class YourPOJOClass {

private char firstChar;
private String address;

public void setFirstChar(char firstChar){
this.firstChar=firstChar;
}
public char getFirstChar(){
return firstChar;
}
public void setAddress(String address){
this.address=address;
}
public String getAddress(){
return address;
}

}

::::::::file.txt:::::::::

I Love India

::::::::file.txt:::::::::




public class Test{

public static void main(String[] args){

YourPOJOClass pojoClass=new YourPOJOClass();

File file=new File("C:\\file.txt");
FileReader reader=new FileReader(file);

char[] contents=new char[20];
reader.read(contents);  //Reding and Storing into contents char[]

    pojoClass.setFirstChar(contents[0]); //Reading the first character and setting to Pojo class variable 'firstChar'
    pojoClass.setAddress(String.valueOf(contents)); //Reading the first character and setting to Pojo class variable 'address'

System.out.println(pojoClass.getFirstChar()); //Output: I
System.out.println(pojoClass.getAddress()); // OutPut: I Love India

}

}