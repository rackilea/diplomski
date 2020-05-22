public static void main(String[] args){
    long i = 0;
    loop: while(true){
        String s = Long.toHexString(i);
        if(s.hashCode() == 0){
            System.out.println("Found: '"+s+"'");
            break loop;
        }
        if(i % 1000000==0){
            System.out.println("checked: "+i);              
        }
        i++;
    }       
}