public static void main(String args[]){
    String a="1234512";

    for(int i=0;i<a.length();i++){
        boolean already = false;
        for(int j = i - 1; j >= 0; --j){
            if(a.charAt(j)==a.charAt(i)){
                already = true;
                break;
            }
        }
        if(already == false){
            System.out.print(a.charAt(i));
        }
    }
}