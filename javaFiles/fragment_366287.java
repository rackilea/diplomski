String str1 = "this is a hello world string";
String str2 = "this is a hello world string and duplicate starts from here this is a hello world string";
Pattern pattern = Pattern.compile(str1);
Matcher matcher = pattern.matcher(str2);

int count = 0;

while(matcher.find()){
    count++;
}

if(count > 0) {
     return true;
} else {
     return false;
}