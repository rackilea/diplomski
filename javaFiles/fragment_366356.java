String resultOut = "http://www.example.com/ex.now#ONEhttp://www.example.com/ex.now#TWO";
String outString = resultOut.replaceAll("^[^#]+#", "");
String[] outArray = outString.split("http[^#]+#");
String res="";

for (String str : outArray) 
{
    res += "{" + str + "}";
}

System.out.println(res);