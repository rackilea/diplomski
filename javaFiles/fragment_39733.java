boolean match = false ;
    for(int i = 0; i < aList.size();i++){
        match = aList.get(i).equals("Red");
        if(match){
            break;
        }
    }
    System.out.print(match);