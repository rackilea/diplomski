String hashTwo="A28904048E";
        long sum=0;
        for(int i=0;i<hashTwo.length();i+=2){
            sum+=Integer.parseInt(""+hashTwo.charAt(i)+hashTwo.charAt(i+1),16);
        }
        System.out.println(Long.toHexString(sum));