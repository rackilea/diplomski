public String toString(){
        StringBuilder str= new StringBuilder();
        for(int i = 0; i < listOfTrees.size(); i++){
            str.append(listOfTrees.get(i));
        }
        return str.toString();
    }