String str="hello,there,(what,is,new),today,(with,you)";
int inside = 0;
int index = 0;
for (int i = 0; i < str.length(); i++){
    if (str.charAt(i) == ')'){
        inside--;
    }else if (str.charAt(i) == '('){
        inside++;
    }else if (str.charAt(i) == ',' && inside == 0){
        System.out.println(str.substring(index, i));
    index = i+1;
    }
}if (index != str.length()){
    System.out.println(str.substring(index, str.length()));
}