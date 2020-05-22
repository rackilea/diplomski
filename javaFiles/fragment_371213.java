public boolean validateRoutingNumber(String s) {

    int checksum=0, len=0, sum=0, mod = 0;
    len = s.length();

    if(len != 9){
        return false;
    }else {
        String newString = s.substring(s.length()-1);
        checksum = Integer.parseInt(newString);

        sum = (7*(Integer.parseInt(""+s.charAt(0))+Integer.parseInt(""+s.charAt(3))+ Integer.parseInt(""+s.charAt(6)))) +
                (3*(Integer.parseInt(""+s.charAt(1))+Integer.parseInt(""+s.charAt(4))+ Integer.parseInt(""+s.charAt(7))))+
             (9*(Integer.parseInt(""+s.charAt(2))+Integer.parseInt(""+s.charAt(5))));


        mod = sum % 10;

        if(mod == checksum)
            return true;
        else
            return false;

    }
}