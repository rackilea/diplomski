//this is expensive    
Pattern p=Pattern.compile("([A-Za-z]+):([0-9]+)[ ]+([A-Za-z]+):([0-9]+)");


    boolean test(String txt){
        Matcher m=p.matcher(txt);
        if(!m.matches())return false;
        int groups=m.groupCount();//should only equal 5 (default whole match+4 groups) here, but you can test this

        System.out.println("Matched: " + m.group(0));
         //Label1 = m.group(1);
         //val1 = m.group(2);
         //Label2 = m.group(3);
         //val2 = m.group(4);

       return true;
    }