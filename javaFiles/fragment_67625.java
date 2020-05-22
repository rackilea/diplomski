String str = "XXX-XXXXXX";
String[] words = str.split("-");
if(words[0].toCharArray().length == 3 && words[1].toCharArray().length == 6 && words.length == 2)
{
    System.out.println("Correct");
}