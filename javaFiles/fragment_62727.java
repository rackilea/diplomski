String str = "DEFGHI";
char[] ch  = str.toCharArray();
for(char c : ch){
    int temp = (int)c;
    int temp_integer = 64; //for upper case
    if(temp<=90 & temp>=65)
        System.out.print(temp-temp_integer);
}