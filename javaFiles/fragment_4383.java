public int orderDigits(int a) {
    String str = a + "";
    char[] charArray = str.toCharArray();
    Arrays.sort(charArray);
    if (a>0)
    {

        String Sorted = new String(charArray);
        return Integer.parseInt(Sorted);
    }
    else if (a<0)
    {   
        int size = 1;
        while(a!=0){
            size++;
            a /= 10;
        }
        String tempStr = new String(charArray);
        String withoutMinus = tempStr.substring(1);         
        String withoutZero = withoutMinus.substring(0, withoutMinus.length());
        StringBuffer sb = new StringBuffer(withoutZero);
        sb.reverse();
        String revStr = sb + "";            
        return -(Integer.parseInt(revStr));
    }
    else{
        return 0;
    }
}