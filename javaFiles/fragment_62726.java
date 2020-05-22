String str = "abcdef";
char[] ch  = str.toCharArray();
for(char c : ch){
    int temp = (int)c;
    int temp_integer = 96; //for lower case
    if(temp<=122 & temp>=97)
        System.out.print(temp-temp_integer);
}