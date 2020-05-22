for (Obj childObj : objectChildren) {
        if(childObj !=null){
            returnList.add(childObj);
            if(childObj.getChildren().size() >0){
                getChildrenTree(childObj,returnList);
            }               
        }
    }
    return returnList;