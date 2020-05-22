// cycle through every component in tableA
private static boolean isAllFilled(GridPane tableA, GridPane tableB){
    for(Node node : tableA.getChildren()){
        if(node instanceof TextField){
            if(((TextField)node).getText().trim().isEmpty()){
                    return false;
            }
        }       
    }

     // cycle through every component in tableB
    for(Node node : tableB.getChildren()){ 
        if(node instanceof TextField){
            if(((TextField)node).getText().trim().isEmpty()){
                    return false;
            }
        }       
    }

    return true; // if all are filled / not empty
}