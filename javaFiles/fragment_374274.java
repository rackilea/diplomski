public static ArrayList<ArrayList<String>> addAfter(String file1)throws IOException{
Scanner scanner = new Scanner(new File(file1));
ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>(); 
ArrayList<String> a = null;
boolean check = false;
while(scanner.hasNextLine())
{
    a = new ArrayList<String>(); // add this
    String str = scanner.nextLine();
    String[] stringArr = str.split(" +");
    for(int i=0; i<stringArr.length; i++){
        a.add(stringArr[i]); //null exception being thrown here
    }
    stringArr = null;
    arr.add(a);
    //a.clear(); -- remove this line
}
return arr;