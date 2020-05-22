boolean result = false;  
Pattern pattern = Pattern.compile("^[a-zA-Z]+$");  
Matcher matcher = pattern.matcher("fgdfgfGHGHKJ68"); // Your String should come here
if(matcher.find())  
    result = true;// There is only Alphabets in your input string
else{  
    result = false;// your string Contains some number/special char etc..
}