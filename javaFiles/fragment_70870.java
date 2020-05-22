public static void main(String[] args) {
    String input = "Sd98TR2asd100";
    char[] chars = input.toCharArray();

    ArrayList<String> numbersAsString = new ArrayList<>();
    String toAdd = "";
    for(int i=0;i<chars.length;i++){
        if(chars[i]>='0' && chars[i]<='9'){
            toAdd += chars[i];
        }
        else{
            if(!toAdd.equals("")){
                numbersAsString.add(toAdd);
                toAdd = new String();
            }
        }
    }
    if(!toAdd.equals("")){
        numbersAsString.add(toAdd);
        toAdd = new String();
    }
    int sum = 0;
    String output = "";
    for(String string : numbersAsString){
        int num = Integer.parseInt(string);
        output += num +"+";
        sum +=num;
    }
    output = output.substring(0,output.length()-2);
    output += "="+ sum;
    System.out.println(output);
}