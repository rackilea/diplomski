String s ="status:ok [XXX][a=XXX b=XXX c=XXX d=XXX e=0 f=XXX g=XXX h=XXX i=XXX j=XXX k=XXX l=XXX m=XXX n=[[XXX][XXX]] p=[[XXX][XXX][XXX][XXX][XXX][XXX][XXX]]] end:end".replaceAll("end:end", "");

    String [] ss  = s.split("=");
    HashMap<Character,Object> myHashMap = new HashMap();
    try{
    for(int i=0;i<ss.length;i++){

        myHashMap.put(ss[i].charAt(ss[i].length()-1), ss[i+1].substring(0, ss[i+1].length()-1).trim());

    }

    }catch(Exception e){
        // do nothing
    }
      System.out.println(myHashMap);
    }