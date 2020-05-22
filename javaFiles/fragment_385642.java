noNoiseLines = new Vector<String>();
    String temp;   

    for(int i = 0; i < input.size(); i++) {


        temp = input.get(i).replaceAll(" a ", " ").replaceAll(" an ", " ").replaceAll(" and ", " ").replaceAll(" the ", " ").replaceAll(" of ", " ").replaceAll(" or ", " ");
        noNoiseLines.add(temp);            
    }
}