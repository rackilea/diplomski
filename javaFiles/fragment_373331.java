public int[] return_binary_encoding(String name, ArrayList<String> names) {

    int code[];
    int domain_size= names.size();
    int siz_of_code= (int)Math.ceil(Math.log(domain_size)/Math.log(2));
    code= new int[siz_of_code];     //it is initialized to 0 by default

    int index= names.indexOf(name);
    String binary_code= Integer.toBinaryString(index);

    //insert binary_code in code from right
    int counter= code.length - 1;
    for(int i= binary_code.length()-1; i>= 0; i--) {
        int digit= Character.getNumericValue(binary_code.charAt(i));
        code[counter]= digit;
        counter --;
    }


    return code;
}