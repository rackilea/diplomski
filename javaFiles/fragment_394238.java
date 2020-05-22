String data = "0,0,1,2,4,5,3,4,6";
String[] array = data.split("(?<=\\G\\d+,\\d+,\\d+),"); //Magic :) 
// to reveal magic see explanation below answer
for(String s : array){
    System.out.println(s);
}